package securitydevice;

public class FSM {
	private int current_state; 
	private String current_output;
	private int[][] stt;	// state transition table
	private String[] out;
	
	private void initialize_stt() {
		this.stt = new int[3][10];
		this.out = new String[3];
		for (int i=0; i<3; i++) {
			for (int j=0; j < 10; j++) {
				this.stt[i][j] = 0;
			}
		}
		stt[0][1] = 1;
		stt[1][1] = 1;
		stt[2][1] = 1;
		stt[0][4] = 2;
		stt[1][4] = 2;
		stt[2][4] = 2;
		
		out[0] = "";
		out[1] = "Unlock";
		out[2] = "Lock";
	}
	
	public FSM() {
		initialize_stt();
		this.current_state = 0;
		this.current_output = this.out[current_state];
	}

	public int state() {
		return current_state;
	}

	public String output() {
		return current_output;
	}

	public void input(int in) {
		int ns;	//next state from the stt
		
		ns = stt[current_state][in];
		current_state = ns;
		current_output = out[current_state];
		return;
	}

	

}