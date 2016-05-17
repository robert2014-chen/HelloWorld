package com.robert.blend.thinking.thread.ticket.test;

import org.junit.Before;
import org.junit.Test;

import com.robert.blend.thinking.thread.ticket.dao.TicketDaoImpl;
import com.robert.blend.thinking.thread.ticket.domain.Ticket;
import com.robert.blend.thinking.utils.JDBCHelper;

public class TicketTest {

	private Ticket ticket = new Ticket();
	private Ticket ticket1 = new Ticket();

	@Before
	public void setup() {
		ticket.setId(1);
		ticket1.setId(2);
	}
	
	@Test
	public void test1(){
		Ticket t = JDBCHelper.newInstance().getEntityById(
				"select * from ticket where id=" + ticket.getId(),
				Ticket.class);

		System.out.println(t.toString());
	}

	@Test
	public void test() {

//		for (int i = 0; i < 10; i++) {
			
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					new TicketDaoImpl().sell(ticket);
//				}
//			}).start();
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					new TicketDaoImpl().sell(ticket1);
//				}
//			}).start();
//		}
	}
}
