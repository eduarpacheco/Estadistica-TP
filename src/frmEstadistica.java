import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class frmEstadistica extends JFrame {
    private JTextField txtDato; 
    private JList lstMuestra;  

    public frmEstadistica() {
        setSize(500, 300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblDato = new JLabel("Dato:");
        lblDato.setBounds(10, 10, 100, 25);
        getContentPane().add(lblDato);

        txtDato = new JTextField();
        txtDato.setBounds(110, 10, 100, 25);
        getContentPane().add(txtDato);

        JButton btnAgregar = new JButton("agregar");
        btnAgregar.setBounds(110, 40, 100, 25);
        getContentPane().add(btnAgregar);

        JButton btnquitar = new JButton("quitar");
        btnquitar.setBounds(110, 70, 100, 25);
        getContentPane().add(btnquitar);

        JLabel lblMuestra = new JLabel("Muestra:");
        lblMuestra.setBounds(220, 10, 100, 25);
        lblMuestra.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblMuestra);

        lstMuestra = new JList();
        JScrollPane spMuestra = new JScrollPane(lstMuestra);
        spMuestra.setBounds(220, 40, 100, 150);
        getContentPane().add(spMuestra);

        JButton btnEstadistica = new JButton("Estadistica");
        btnEstadistica.setBounds(10, 200, 100, 25);
        getContentPane().add(btnEstadistica);

        JComboBox cmbEstadistica = new JComboBox();
        String[] opciones = new String[] { "sumatoria", "promedio", "desviacion estandar", "maximo", "minimo", "moda" };
        DefaultComboBoxModel dcm = new DefaultComboBoxModel(opciones);
        cmbEstadistica.setModel(dcm);
        cmbEstadistica.setBounds(110, 200, 100, 25);
        getContentPane().add(cmbEstadistica);

        JTextField txtEstadistica = new JTextField();
        txtEstadistica.setBounds(220, 200, 100, 25);
        txtEstadistica.setEnabled(false);
        getContentPane().add(txtEstadistica);

        // crear eventos
        btnAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                agregardato();
            }

        });

        btnquitar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                quitardato();
            }

        });

        btnEstadistica.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEstadistica();
            }

        });

    }

    private int MAXIMODATOS = 1000;
    private double[] muestra = new double[MAXIMODATOS];
    private int totaldatos = 0;

    private void agregardato() {
        if (totaldatos < MAXIMODATOS) {
            muestra[totaldatos]=Double.parseDouble(txtDato.getText())
            totaldatos++; 
            mostrardato();

        } else {
            JOptionPane.showMessageDialog(null, "no se pueden mostrar mas datos");
        }

    }
    private void mostrardato(){
        String[] strmuestra=new String[totaldatos];
        for(int i=0;i<totaldatos;i++){
            strmuestra[i] = String.valueOf(muestra[i]);

        }
        lstMuestra.setListData(strmuestra); 
    }

    private void quitardato() {
        JOptionPane.showMessageDialog(null, "hizo clic en Quitar");
    }

    private void calcularEstadistica() {
        JOptionPane.showMessageDialog(null, "hizo clic en Calcular Estadistica");
    }

}
