import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// import java.io.DataInputStream;
// import java.io.DataOutputStream;
// import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class userthree implements ActionListener,Runnable {
    JLabel send, send1, rupee, smile7;
    JTextField message;
   static JPanel a1;
   static Box vertical = Box.createVerticalBox();
    // static DataOutputStream dout;
    static JFrame f = new JFrame();
    BufferedReader reader;
    BufferedWriter writer;
    String name="Sweety Singh";

    userthree() {
       f. setBounds(450, 85, 400, 540);
       f. setLayout(null);
        // setTitle("Add Personal Details");
       f. getContentPane().setBackground(Color.WHITE);
       f. setUndecorated(true);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        // adding panel component on jframe
        // creating custom layout using setBounds() method
        p1.setBounds(0, 0, 400, 70);
        p1.setLayout(null);
       f. add(p1);

        // JButton arr = new JButton();
        // arr.setBounds(0, 20,50,30 );
        // arr.setBackground(new Color(7,94,84));
        // p1.add(arr);

        // adding images on panel

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("3.png"));
        Image i11 = i10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image = new JLabel(i12);
        image.setBounds(5, 20, 25, 25);
        p1.add(image);

        // as soon as i clicked arrow frame should be close, for that i need to add
        // actionlistener on it

        image.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // setVisible(false);
                System.exit(0);
            }

        });

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mirzapur.png"));
        Image i2 = i1.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel profile = new JLabel(i3);
        profile.setBounds(40, 18, 35, 35);
        p1.add(profile);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("video.png"));
        Image i5 = i4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel video = new JLabel(i6);
        video.setBounds(250, 23, 25, 25);
        // video.addMouseListener(new MouseAdapter(){
        // public void mouseClicked(MouseEvent e) {
        // try {
        // Runtime.getRuntime().exec("notepad.exe");
        // // Runtime is a class
        // // which takes a static method called getRuntime().
        // } catch (IOException e1) {

        // e1.printStackTrace();
        // }
        // }
        // });
        p1.add(video);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("phone.png"));
        Image i8 = i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel call = new JLabel(i9);
        call.setBounds(300, 23, 25, 25);
        p1.add(call);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel icon = new JLabel(i15);
        icon.setBounds(355, 23, 10, 25);
        p1.add(icon);

        JLabel heading = new JLabel("Mirzapur Group");
        heading.setBounds(85, 15, 200, 25);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        p1.add(heading);

        JLabel status = new JLabel("Sweety,Bablu,Kaleen,Guddu");
        status.setBounds(85, 32, 100, 25);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(status);

        // panel for footer
        a1 = new JPanel();
        // adding panel component on jframe
        // creating custom layout using setBounds() method
        a1.setBounds(5, 72, 390, 410);
        a1.setLayout(null);
        a1.setBackground(Color.WHITE);
        f.add(a1);

        message = new JTextField();
        message.setBounds(45, 490, 200, 45);
        message.setBorder(BorderFactory.createEmptyBorder());
        message.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        message.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                // String name2 = message.getText();
                // char[] chars = name2.toCharArray();
                // for (char c : chars) {
                // if ((!Character.isLetter(c) && (!Character.isDigit(c) &&
                // (!Character.isLowerCase(c)
                // && (!Character.isUpperCase(c)) && (!Character.isWhitespace(c)))))) {
                // send.setVisible(false);
                // } else {
                // send.setVisible(true);
                // }
                // }
                if (!message.getText().equals("")) {
                    // if textbox not empty
                    send.setVisible(false);
                    // send means microphone
                    send1.setVisible(true);
                    // message sending arrow
                    rupee.setVisible(false);
                    smile7.setBounds(290, 490, 50, 50);

                } else {
                    // if textbox is empty
                    send.setVisible(true);
                    // send means microphone
                    send1.setVisible(false);
                    // send means microphone
                    rupee.setVisible(true);
                    smile7.setBounds(250, 490, 50, 50);
                }

            }
        });
       f. add(message);

        ImageIcon i91 = new ImageIcon(ClassLoader.getSystemResource("smiley.png"));
        Image i92 = i91.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i93 = new ImageIcon(i92);
        JLabel smile = new JLabel(i93);
        smile.setBounds(10, 500, 25, 25);
        f.add(smile);

        ImageIcon i81 = new ImageIcon(ClassLoader.getSystemResource("microphone.png"));
        Image i82 = i81.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon i83 = new ImageIcon(i82);
        send = new JLabel(i83);
        send.setBounds(335, 495, 35, 35);
       f. add(send);

        ImageIcon i51 = new ImageIcon(ClassLoader.getSystemResource("sending.png"));
        Image i52 = i51.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon i53 = new ImageIcon(i52);
        send1 = new JLabel(i53);
        send1.setBounds(335, 495, 35, 35);
        send1.setVisible(false);
        send1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {

                String output ="<html><p>"+ name +"</p><p>"+ message.getText()+"</p></html>";
                // taking message from textfield
                // getText() returns a string
                // JLabel out = new JLabel(output);
                JPanel p2 = formatLabel(output);
              
                // p2.add(out);

                // setting panel layout as border layout
                a1.setLayout(new BorderLayout());
                // borderlayout placed element at top,left,bottom,right,center
                // working on client machine message should be display at right side for that we
                // have to use boxlayout which will be declare globally.
                JPanel right = new JPanel(new BorderLayout());
                right.setBackground(Color.WHITE);
                right.add(p2, BorderLayout.LINE_END);
                // we can add panel but we cant add string directly so thats why
                // string->JLabel->p2->right->vertical
                vertical.add(right);
                vertical.add(Box.createVerticalStrut(15));
                // set every item on panel a1
                a1.add(vertical, BorderLayout.PAGE_START);

                // check if server is onn or not.
                // optional
                
                try {
                    writer.write(output);
                    writer.write("\r\n");
                    writer.flush();
                } catch (Exception e1) {
                   e1.printStackTrace();
                }

                // we have to empty our textfield after sending messages.
                message.setText("");

                // we have to repaint() will reload the frame
                // this three methods used to recall the frame
               f. repaint();
               f. invalidate();
                // mostly use validate()
               f. validate();
                // working
                // Box.CreateverticalBox is use to align elements vertcally on right side
                // one-by-one with 15 cm of gap
                // with the help of a1.setLayout(new BorderLayout()); we have sended message on
                // right.add(p2,BorderLayout.LINE_END);
                // aligining vertical on a1.add(vertical,BorderLayout.PAGE_START);
                // adding vertical.add(right) and vertical.add(Box.createVerticalStrut(15)) on
                // panel with the help of JPanel right = new JPanel(new BorderLayout());

                     // ............................end...........................................

             // sending message using DataOutputStream dout with writeUTF() protocol on arrow click to server to client
             
            //  dout.writeUTF(output);     
             } catch (Exception e1) {
               e1.printStackTrace();
             }

            }

            public JPanel formatLabel(String output) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.WHITE);
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                JLabel out = new JLabel("<html><p style=\"width: 150px\">" + output + "</p></html>");
                out.setFont(new Font("Tahoma", Font.PLAIN, 16));
                out.setBackground(new Color(37, 211, 102));
                // setOpaque() will allow color to display at border
                out.setOpaque(true);
                // for adding padding
                out.setBorder(new EmptyBorder(0, 15, 0, 50));
                panel.add(out);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                JLabel time = new JLabel();
                // setText() dynamically sets the value on JLabel
                time.setText(sdf.format(cal.getTime()));
                // cal.getTime() use to counter current value.
                // and sdf use to format the current time
                panel.add(time);

                return panel;
            }

        });

       f. add(send1);

        // i need a box to display our messages for that we need a box

        ImageIcon i71 = new ImageIcon(ClassLoader.getSystemResource("clip.jpeg"));
        Image i72 = i71.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i73 = new ImageIcon(i72);
        smile7 = new JLabel(i73);
        smile7.setBounds(250, 490, 50, 50);
       f. add(smile7);

        ImageIcon i61 = new ImageIcon(ClassLoader.getSystemResource("rupee.png"));
        Image i62 = i61.getImage().getScaledInstance(30, 25, Image.SCALE_DEFAULT);
        ImageIcon i63 = new ImageIcon(i62);
        rupee = new JLabel(i63);
        rupee.setBounds(290, 500, 30, 25);
       f. add(rupee);

       f. setVisible(true);

        try {
            // This is a socket and we have to connect this with server.
            Socket socket = new Socket("127.0.0.1",2003);
            // mention address of localhost or else we can write "localhost".
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));



        } catch (Exception e) {
          e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       userthree three = new userthree();
       Thread thread = new Thread(three);
       thread.start();
        // try {
        //     Socket s = new Socket("127.0.0.1",6001);
        //     System.out.println(s);
        //     DataInputStream din = new DataInputStream(s.getInputStream());
        //     dout = new DataOutputStream(s.getOutputStream()); 
        //     while (true) {
        //         a1.setLayout(new BorderLayout());
        //         // making JPanel al static globally.
        //         String msg = din.readUTF();
        //         JPanel panel = formatLabel(msg);
        //         JPanel left = new JPanel(new BorderLayout());
        //         left.add(panel, BorderLayout.LINE_START);
        //         vertical.add(left);
        //         // dispalying messages on leftside which is coming from server
        //         vertical.add(Box.createVerticalStrut(15));
        //         a1.add(vertical,BorderLayout.PAGE_START);

        //         f.validate();
        //         }
        // } catch (Exception e) {
        //    e.printStackTrace();
        // }
    }

    // private static JPanel formatLabel(String msg) {
    //     JPanel panel = new JPanel();
    //     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    //     JLabel out = new JLabel("<html><p style=\"width: 150px\">" + msg + "</p></html>");
    //     out.setFont(new Font("Tahoma", Font.PLAIN, 16));
    //     out.setBackground(new Color(37, 211, 102));
    //     // setOpaque() will allow color to display at border
    //     out.setOpaque(true);
    //     // for adding padding
    //     out.setBorder(new EmptyBorder(15, 15, 15, 50));
    //     panel.add(out);

    //     Calendar cal = Calendar.getInstance();
    //     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    //     JLabel time = new JLabel();
    //     // setText() dynamically sets the value on JLabel
    //     time.setText(sdf.format(cal.getTime()));
    //     // cal.getTime() use to counter current value.
    //     // and sdf use to format the current time
    //     panel.add(time);

    //     return panel;
    // }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
        try {
            String msg="";
            while (true) {

                msg = reader.readLine();
                // using object of bufferedreader class for reading lines
                
                
                if(msg.contains(name)){
                    continue;
                }
                
                JPanel panel = formatLabel(msg);
                JPanel left = new JPanel(new BorderLayout());
                left.setBackground(Color.WHITE);
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));
                a1.add(vertical,BorderLayout.PAGE_START);

                f.validate();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
     
    }

    private JPanel formatLabel(String msg) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel out = new JLabel("<html><p style=\"width: 150px\">" + msg + "</p></html>");
        out.setFont(new Font("Tahoma", Font.PLAIN, 16));
        out.setBackground(new Color(37, 211, 102));
        // setOpaque() will allow color to display at border
        out.setOpaque(true);
        // for adding padding
        out.setBorder(new EmptyBorder(0, 15,0, 50));
        panel.add(out);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        // setText() dynamically sets the value on JLabel
        time.setText(sdf.format(cal.getTime()));
        // cal.getTime() use to counter current value.
        // and sdf use to format the current time
        panel.add(time);

        return panel;
    }
}


