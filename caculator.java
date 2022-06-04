package hiclass;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;//jframe�߰�
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class caculator extends JFrame {//jframe�� ��ӹ޾� calculator����
   //jframe��ü(�ν��Ͻ�) ����
   private double op1 = 0;//�޴¼���
   private double op2 = 0;//�״��� �޴� ����
   private String operator;//��ȣ�޴� ���ڿ�
   
   caculator(){//���� ���
      this.setTitle("����");//â�� Ÿ��Ʋ���� ����
      Image picture = Toolkit.getDefaultToolkit().getImage("calculator.gif");//���α׷� �������̹���
      this.setIconImage(picture);
      this.setBounds(100,100,400,500);//��ũ�� ����
      this.setLayout(new BorderLayout());
      JTextField display = new JTextField("0");
      display.setFont(new Font("�ü�ü", Font.BOLD, 50));//�۾�ü
      display.setHorizontalAlignment(JTextField.RIGHT);
      JPanel panel = new JPanel();//�г� �߰�
      panel.setLayout(new GridLayout(4, 4));//������ ���� ���̾ƿ��� ����
      JLabel status = new JLabel("�����Դϴ�");
      
      for (int i = 0; i < 10; i++) {
         JButton btn = new JButton("" + i);
         btn.addActionListener(e-> {
            if(display.getText().equals("0")) {
               display.setText(btn.getText());
            }
            else {
               display.setText(display.getText() + btn.getText());
            }
         });
         panel.add(btn);//���� ��ư�߰�
      }
      
      JButton btnEqual = new JButton("=");
      btnEqual.addActionListener(e->{
         op2 = Double.parseDouble(display.getText());//�Ҽ��� ���� �ٲ㼭 ǥ��
         double result = calc(op1, op2, operator);//op1, op2, ��ȣ �Ű����� ����
         display.setText(""+ result);//result��� ǥ���ϱ�
         status.setText(String.valueOf(op1 + operator + op2));//�����Ÿ����
      });//�г�.addactionlistner->�̰ɴ����� �����Ұ�
      panel.add(btnEqual);//��� ��Ÿ����
      
      //�������ǿ� ������ ������ �����ϰ� �;��� ���
      JButton btncancel = new JButton("C");
      btncancel.addActionListener(e->{
        display.setText("0");//����߱⿡ 0���� ǥ��
         operator = "C";//cancel�̶�� �Ű������� c�� ����
         status.setText("0");
      });
      panel.add(btncancel);//�������г� �߰�
      
      JButton btnPlus = new JButton("+");
      btnPlus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");//0���� ǥ��
         operator = "+";//���ϱ� ����
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btnPlus);//���ϱ��г� �߰�
      
      JButton btnMinus = new JButton("-");
      btnMinus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "-";
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btnMinus);//�����г� �߰�
      
      JButton btndivison = new JButton("/");
      btndivison.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "/";
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btndivison);//�������г� �߰�
      
      JButton btnmultiply = new JButton("*");
      btnmultiply.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "*";
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btnmultiply);//�÷����г� �߰�
      
      JButton btnDot = new JButton(".");
      btnDot.addActionListener(e->{
         if(!display.getText().contains(".")) {
            display.setText(display.getText()+ btnDot.getText());
         }
      });
      panel.add(btnDot);//�Ҽ����г� �߰�
      
      this.add(panel);

      this.add(BorderLayout.NORTH, display);//ȭ���� ����
      this.add(BorderLayout.CENTER, panel);//��ư �гε��� �߰���
      this.add(BorderLayout.SOUTH, status);//���ʿ� status �߰�
      //borderlayout.����
      
   }
   
   private double calc(double op1, double op2, String operator) {
      double result = 0;
      switch(operator) {
      case "+":
         result = op1 + op2;
         break;// ���ϱ���
      case "-":
         result = op1 - op2;
         break;// ������
      case "*":
         result = op1 * op2;
         break;// ���ϱ���
      case "/":
         result = op1 / op2;
         break;// ��������
      case "C"://�������ǿ� ������ ������ �����ϰ� �;��� ���
        result=0;
        break;//result�� 0���� ����� ��ұ�ɰ� ������
      }
      return result;
   }
   
   public static void main(String[] args) {
      new caculator().setVisible(true);//â�� ȭ�鿡 ��Ÿ��
   }

}