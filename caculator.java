package hiclass;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;//jframe추가
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class caculator extends JFrame {//jframe을 상속받아 calculator생성
   //jframe객체(인스턴스) 생성
   private double op1 = 0;//받는숫자
   private double op2 = 0;//그다음 받는 숫자
   private String operator;//기호받는 문자열
   
   caculator(){//계산기 기능
      this.setTitle("계산기");//창의 타이틀바의 내용
      Image picture = Toolkit.getDefaultToolkit().getImage("calculator.gif");//프로그램 아이콘이미지
      this.setIconImage(picture);
      this.setBounds(100,100,400,500);//라벨크기 설정
      this.setLayout(new BorderLayout());
      JTextField display = new JTextField("0");
      display.setFont(new Font("궁서체", Font.BOLD, 50));//글씨체
      display.setHorizontalAlignment(JTextField.RIGHT);
      JPanel panel = new JPanel();//패널 추가
      panel.setLayout(new GridLayout(4, 4));//지정된 수의 레이아웃을 가짐
      JLabel status = new JLabel("계산기입니다");
      
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
         panel.add(btn);//숫자 버튼추가
      }
      
      JButton btnEqual = new JButton("=");
      btnEqual.addActionListener(e->{
         op2 = Double.parseDouble(display.getText());//소수점 숫자 바꿔서 표시
         double result = calc(op1, op2, operator);//op1, op2, 부호 매개변수 전달
         display.setText(""+ result);//result라고 표시하기
         status.setText(String.valueOf(op1 + operator + op2));//결과나타내기
      });//패널.addactionlistner->이걸누르면 실행할것
      panel.add(btnEqual);//결과 나타내기
      
      //과제조건에 맞지는 않지만 구현하고 싶었던 기능
      JButton btncancel = new JButton("C");
      btncancel.addActionListener(e->{
        display.setText("0");//취소했기에 0으로 표시
         operator = "C";//cancel이라는 매개변수를 c로 전달
         status.setText("0");
      });
      panel.add(btncancel);//계산취소패널 추가
      
      JButton btnPlus = new JButton("+");
      btnPlus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");//0으로 표시
         operator = "+";//더하기 전달
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btnPlus);//더하기패널 추가
      
      JButton btnMinus = new JButton("-");
      btnMinus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "-";
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btnMinus);//빼기패널 추가
      
      JButton btndivison = new JButton("/");
      btndivison.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "/";
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btndivison);//나누기패널 추가
      
      JButton btnmultiply = new JButton("*");
      btnmultiply.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "*";
         status.setText(String.valueOf(op1 + operator));
      });
      panel.add(btnmultiply);//플러스패널 추가
      
      JButton btnDot = new JButton(".");
      btnDot.addActionListener(e->{
         if(!display.getText().contains(".")) {
            display.setText(display.getText()+ btnDot.getText());
         }
      });
      panel.add(btnDot);//소수점패널 추가
      
      this.add(panel);

      this.add(BorderLayout.NORTH, display);//화면은 위에
      this.add(BorderLayout.CENTER, panel);//버튼 패널들은 중간에
      this.add(BorderLayout.SOUTH, status);//남쪽에 status 추가
      //borderlayout.방향
      
   }
   
   private double calc(double op1, double op2, String operator) {
      double result = 0;
      switch(operator) {
      case "+":
         result = op1 + op2;
         break;// 더하기기능
      case "-":
         result = op1 - op2;
         break;// 빼기기능
      case "*":
         result = op1 * op2;
         break;// 곱하기기능
      case "/":
         result = op1 / op2;
         break;// 나누기기능
      case "C"://과제조건에 맞지는 않지만 구현하고 싶었던 기능
        result=0;
        break;//result를 0으로 만들면 취소기능과 같아짐
      }
      return result;
   }
   
   public static void main(String[] args) {
      new caculator().setVisible(true);//창을 화면에 나타냄
   }

}