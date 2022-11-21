package securitydevice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FSMTest {

	@Test
	void test_new_instance_initial_state_is_start() {
		FSM sd = new FSM();
		assertEquals(0, sd.state());
	}

	@Test
	void test_new_instance_output_is_empty_string() {
		FSM sd = new FSM();
		assertEquals("", sd.output());
	}

	@Test
	void test_1_changes_state_to_got_1() {
		FSM sd = new FSM();
		sd.input(1);
		assertEquals(1, sd.state());
	}

	@Test
	void test_that_output_in_state_got_1_is_Unlock() {
		FSM sd = new FSM();
		sd.input(1);
		assertEquals("Unlock", sd.output());
	}

	@Test
	void test_4_changes_state_to_got_4() {
		FSM sd = new FSM();
		sd.input(4);
		assertEquals(2, sd.state());
	}

	@Test
	void test_that_output_in_state_got_4_is_Lock() {
		FSM sd = new FSM();
		sd.input(4);
		assertEquals("Lock", sd.output());
	}

	@Test
	void test_digit_other_than_1_or_4_changes_state_to_start() {
		FSM sd = new FSM();
		sd.input(7);
		assertEquals(0, sd.state());
	}

	@Test
	void test_4_changes_state_from_got_1_to_got_4() {
		FSM sd = new FSM();
		sd.input(1);
		sd.input(4);
		assertEquals(2, sd.state());
	}

}


