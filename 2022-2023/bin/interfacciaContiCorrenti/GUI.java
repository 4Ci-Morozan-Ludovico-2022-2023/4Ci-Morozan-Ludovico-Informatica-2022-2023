import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.util.*;
import java.io.*;

public class GUI extends JFrame implements ActionListener{
    private Calculator calculator = new Calculator();
    
    private JLabel titolareLabel;
    private JLabel pinLabel;
    private JLabel importoLabel;
    private JLabel saldoLabel;
    private JLabel riceventeLabel;
    private JTextField titolare;
    private JPasswordField pin;
    private JTextField importo;
    private JTextField ricevente;
    private JTextArea saldo;
    private JButton apri;
    private JButton chiudi;
    private JButton preleva;
    private JButton deposita;
    private JButton saldoButton;
    private JButton reset;
    private JButton trasferisci;
    
    public GUI(){
        try{
            calculator.start();
        }catch(FileNotFoundException ex){
            File file = new File("archivio.txt");
            showErrorMessage("il precedente file d'archivio non è stato trovato, quindi ne è stato creato uno");
        }
        
        this.setTitle("Conto");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000, 1000));
        this.getContentPane().setBackground(new Color(86, 86, 86));
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        
        this.titolareLabel = new JLabel("TITOLARE: ");
        this.pinLabel = new JLabel("PIN: ");
        this.importoLabel = new JLabel("IMPORTO: ");
        this.saldoLabel = new JLabel("SALDO: ");
        this.riceventeLabel = new JLabel("RICEVENTE: ");
        this.titolare = new JTextField(20);
        this.pin = new JPasswordField(20);
        this.importo = new JTextField(20);
        this.ricevente = new JTextField(20);
        this.saldo = new JTextArea(1,5);
        this.saldo.setEditable(false);
        
        this.apri = createButton("APRI", Color.GREEN);
        this.apri.addActionListener(this);
        this.chiudi = createButton("CHIUDI ", Color.RED);
        this.chiudi.addActionListener(this);
        this.preleva = createButton("PRELEVA", Color.BLUE);
        this.preleva.addActionListener(this);
        this.deposita = createButton("DEPOSITA", Color.BLUE);
        this.deposita.addActionListener(this);
        this.saldoButton = createButton("SALDO", Color.ORANGE);
        this.saldoButton.addActionListener(this);
        this.reset = createButton("RESET", Color.GRAY);
        this.reset.addActionListener(this);
        this.trasferisci = createButton("TRASFERISCI", Color.CYAN);
        this.trasferisci.addActionListener(this);
        
        this.definePosition(constraints, 0, 0);
        this.add(titolareLabel, constraints);
        
        this.definePosition(constraints, 1, 0);
        this.add(titolare, constraints);
        
        this.definePosition(constraints, 2, 0);
        this.add(apri, constraints);
        
        this.definePosition(constraints, 3, 0);
        this.add(chiudi, constraints);
        
        this.definePosition(constraints, 0, 1);
        this.add(pinLabel, constraints);
        
        this.definePosition(constraints, 1, 1);
        this.add(pin, constraints);
        
        this.definePosition(constraints, 0, 2);
        this.add(importoLabel, constraints);
        
        this.definePosition(constraints, 1, 2);
        this.add(importo, constraints);
        
        this.definePosition(constraints, 2, 2);
        this.add(preleva, constraints);
        
        this.definePosition(constraints, 3, 2);
        this.add(deposita, constraints);
        
        this.definePosition(constraints, 0, 3);
        this.add(saldoLabel, constraints);
        
        this.definePosition(constraints, 1, 3);
        this.add(saldo, constraints);
        
        this.definePosition(constraints, 2, 3);
        this.add(saldoButton, constraints);
        
        this.definePosition(constraints, 3, 3);
        this.add(reset, constraints);
        
        this.definePosition(constraints, 0, 4);
        this.add(riceventeLabel, constraints);
        
        this.definePosition(constraints, 1, 4);
        this.add(ricevente, constraints);
        
        this.definePosition(constraints, 2, 4);
        this.add(trasferisci, constraints);
        
        this.setVisible(true);
    }
    //
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        return button;
    }
    //
    private GridBagConstraints definePosition(GridBagConstraints constraints, int x, int y){
        constraints.gridx = x;
        constraints.gridy = y;
        return constraints;
    }
    //
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==apri){
            try {
                actionApri();
            } catch (IOException ex) {
                showErrorMessage("errore durante l'aggiunta del conto");
            }
        }else if(e.getSource()==chiudi){
            try {
                actionChiudi();
            } catch (IOException ex) {
                showErrorMessage("errore durante la chiusura del conto");
            }
        }else if(e.getSource()==preleva){
            try {
                actionPreleva();
            } catch (IOException ex) {
                showErrorMessage("errore durante il prelievo dal conto");
            }
        }else if(e.getSource()==deposita){
            try {
                actionDeposita();
            } catch (IOException ex) {
                showErrorMessage("errore durante il deposito sul conto");
            }
        }else if(e.getSource()==saldoButton){
            try {
                actionSaldo();
            } catch (IOException ex) {
                showErrorMessage("errore");
            }
        }else if(e.getSource()==reset){
            reset();
        }else if(e.getSource()==trasferisci){
            try {
                actionTrasferisci();
            } catch (IOException ex) {
                showErrorMessage("errore durante il trasferimento");
            }
        }
    }

    public void actionApri() throws IOException{
        ContoCorrente conto = new ContoCorrente(getInputsForApri());
        if(calculator.nonEsiste(conto)){
            calculator.aggiungiConto(conto);
            showSaldo(conto);
            showInfoMessage("aperto conto a nome: " + conto.getTitolare());
        }else{
            conto = null;
            showErrorMessage("il conto inserito è già esistente");
        }
    }
    
    public void actionChiudi() throws IOException{
        ContoCorrente conto = new ContoCorrente(getInputsForChiudi());
        if(calculator.nonEsiste(conto)){
            showErrorMessage("impossibile chiudere conto a nome: " + conto.getTitolare() + ", perchè non esistente");
        }else{
            if(calculator.controlloPin(conto)){
                calculator.cancellaConto(conto);
                showInfoMessage("cancellato conto a nome: " + conto.getTitolare());
            }else{
                showErrorMessage("pin del conto a nome: "+conto.getTitolare()+", errato");
            }
        }
    }
    
    public void actionPreleva() throws IOException{
        ContoCorrente conto = new ContoCorrente(getInputsForApri());
        if(calculator.nonEsiste(conto)){
            showErrorMessage("impossibile prelevare dal conto a nome: " + conto.getTitolare() + ", perchè non esistente");
        }else{
            if(calculator.controlloPin(conto)){
                if(calculator.controlloDisponibilità(conto)){
                    calculator.preleva(conto);
                    showSaldo(conto);
                    showInfoMessage("prelievo effettuato");
                }else{
                    showErrorMessage("saldo del conto a nome: "+conto.getTitolare()+", insufficiente");
                }
            }else{
                showErrorMessage("pin del conto a nome "+conto.getTitolare()+", errato");
            }
        }
    }

    public void actionDeposita() throws IOException{
        ContoCorrente conto = new ContoCorrente(getInputsForApri());
        if(calculator.nonEsiste(conto)){
            showErrorMessage("impossibile depositare sul conto a nome: " + conto.getTitolare() + ", perchè non esistente");
        }else{
            if(calculator.controlloPin(conto)){
                calculator.deposita(conto);
                showSaldo(conto);
                showInfoMessage("deposito effettuato");
            }else{
                showErrorMessage("pin del conto a nome "+conto.getTitolare()+", errato");
            }
        }
    }
    
    public void actionSaldo() throws IOException{
        ContoCorrente conto = new ContoCorrente(getInputsForChiudi());
        if(calculator.nonEsiste(conto)){
            showErrorMessage("impossibile mostrare saldo del conto a nome: " + conto.getTitolare() + ", perchè non esistente");
        }else{
            if(calculator.controlloPin(conto)){
                showSaldo(conto);
            }else{
                showErrorMessage("pin del conto a nome: "+conto.getTitolare()+", errato");
            }
        }
    }
    
    public void showSaldo(ContoCorrente conto){
        saldo.setText(calculator.getSaldo(conto));
    }
    
    public void reset(){
        titolare.setText("");
        pin.setText("");
        importo.setText("");
        saldo.setText("");
        ricevente.setText("");
    }
    
    public void actionTrasferisci() throws IOException{
        ContoCorrente conto = new ContoCorrente(getInputsForApri());
        ContoCorrente contoRicevente = new ContoCorrente(getInputsForTrasferisci());
        if(calculator.nonEsiste(conto)){
            showErrorMessage("impossibile trasferire dal conto a nome: " + conto.getTitolare() + ", perchè non esistente");
        }else{
            if(!calculator.nonEsiste(contoRicevente)){
                if(calculator.controlloPin(conto)){
                    if(calculator.controlloDisponibilità(conto)){
                        calculator.preleva(conto);
                        calculator.deposita(contoRicevente);
                        showSaldo(conto);
                        showInfoMessage("trasferimento effettuato");
                    }else{
                        showErrorMessage("saldo del conto a nome: "+conto.getTitolare()+", insufficiente");
                    }
                }else{
                    showErrorMessage("pin del conto a nome: "+conto.getTitolare()+", errato");
                }
            }else{
                showInfoMessage("impossibile trasferire sul conto a nome: " + contoRicevente.getTitolare() + ", perchè non esistente");
            }
        }
    }
    
    public ContoCorrente getInputsForApri(){
        String titolare = this.titolare.getText();
        if(titolare.equals("")){
            showErrorMessage("necessario completare campo titolare");
            return null;      
        }else{
            String strPin = new String(this.pin.getPassword());
            String strSaldo = new String(this.importo.getText());
            if(strPin.matches("\\d+")){
                int pin = Integer.parseInt(strPin);
                try{
                    double saldo = Double.parseDouble(strSaldo);
                    if(saldo >= 0){
                        ContoCorrente conto = new ContoCorrente(titolare, pin, saldo);
                        return conto;
                    }else{
                        showErrorMessage("importo non può contenere valori negativi");
                        return null;
                    }
                } catch (NumberFormatException e) {
                    showErrorMessage("importo deve contenere valori double, come separatore il punto");
                    return null;
                }
            }else{
                showErrorMessage("pin deve contenere valori interi");
                return null;
            }
        }
    }
    
    public ContoCorrente getInputsForTrasferisci(){
        String ricevente = this.ricevente.getText();
        if(ricevente.equals("")){
            showErrorMessage("necessario completare campo ricevente");
            return null;      
        }else{
            int pin = 0;
            String strSaldo = new String(this.importo.getText());
            try{
                double saldo = Double.parseDouble(strSaldo);
                if(saldo >= 0){
                    ContoCorrente conto = new ContoCorrente(ricevente, pin, saldo);
                    return conto;
                }else{
                    showErrorMessage("importo non può contenere valori negativi");
                    return null;
                }
            } catch (NumberFormatException e) {
                showErrorMessage("importo deve contenere valori double, come separatore il punto");
                return null;
            }
        }
    }
    
    public ContoCorrente getInputsForChiudi(){
        String titolare = this.titolare.getText();
        if(titolare.equals("")){
            showErrorMessage("necessario completare campo titolare");
            return null;      
        }else{
            String strPin = new String(this.pin.getPassword());
            if(strPin.matches("\\d+")){
                int pin = Integer.parseInt(strPin);
                ContoCorrente conto = new ContoCorrente(titolare, pin, 0.0);
                return conto;
            }else{
                showErrorMessage("pin deve contenere valori interi");
                return null;
            }
        }
    }
    
    private void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Informazione", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }
}
