package memento;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OriginatorChess chess=new OriginatorChess(new MementoChess("��",2,2));
		
		play(chess);
		chess.setX(3);
		play(chess);
		chess.setY(6);
		play(chess);
		
		undo(chess);
		undo(chess);
		redo(chess);
		redo(chess);
		
	}
	
	private static int index=0;
	private static CaretakerChess caretaker=new CaretakerChess();
	
	
	public static void play(OriginatorChess chess) {//��ӵ�����¼
		index++;
		caretaker.addMem(chess.SavetoMemento());
		chess.Show();
		
	}
	
	public static void undo(OriginatorChess chess) {//����
		System.out.println("**********����************");
		index--;
		chess.Restore(caretaker.getMem(index-1));
		chess.Show();
	}

	public static void redo(OriginatorChess chess) {//��������
		System.out.println("**********��������************");
		chess.Restore(caretaker.getMem(index));
		index++;
		chess.Show();
	}

}
