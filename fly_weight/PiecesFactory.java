package fly_weight;

import java.util.HashMap;
import java.util.Hashtable;

public class PiecesFactory {
	private HashMap piecePool=new HashMap();
	public APiece GetPiece(String key) {
		if(!piecePool.containsKey(key)) {
			APiece p=new OnePiece(key);
			piecePool.put(key, p);
			return p;
		}else
			return (APiece)piecePool.get(key);
	}
	public int getPiecesCount() {
		return piecePool.size();
	}
}
