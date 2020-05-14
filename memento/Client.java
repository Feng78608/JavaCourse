package memento;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OriginatorChess chess=new OriginatorChess(new MementoChess("ºÚ",2,2));
		
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
	
	
	public static void play(OriginatorChess chess) {//Ìí¼Óµ½±¸ÍüÂ¼
		index++;
		caretaker.addMem(chess.SavetoMemento());
		chess.Show();
		
	}
	
	public static void undo(OriginatorChess chess) {//»ÚÆå
		System.out.println("**********»ÚÆå************");
		index--;
		chess.Restore(caretaker.getMem(index-1));
		chess.Show();
	}

	public static void redo(OriginatorChess chess) {//³·Ïú»ÚÆå
		System.out.println("**********³·Ïú»ÚÆå************");
		chess.Restore(caretaker.getMem(index));
		index++;
		chess.Show();
	}

}
