package com.robert.blend.thinking.thread.ticket.dao;

import com.robert.blend.thinking.thread.ticket.domain.Ticket;
import com.robert.blend.thinking.utils.JDBCHelper;

public class TicketDaoImpl {

	public boolean sell(Ticket ticket) {
		synchronized (ticket.getId()) {
			System.out.println("start to sell " + ticket.getId() + " ticket");

			Ticket t = JDBCHelper.newInstance().getEntityById(
					"select * from ticket where id=" + ticket.getId(),
					Ticket.class);

			System.out.println(t.toString());

			int num = t.getNum();
			System.out.println(num);
			if (num > 0) {
				
				try {
					Thread.sleep(5*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				JDBCHelper.newInstance().update(
						"update ticket set num=" + (num - 1) + " where id = "
								+ t.getId());
				System.out.println("sell success");
			} else {
				System.out.println("there is not enough ticket");
			}
			System.out.println("end to sell " + ticket.getId() + " ticket");
			return true;
		}
	}

	private int queryTicket(Ticket ticket) {
		System.out
				.println("query the surplus of " + ticket.getId() + " ticket");
		if (ticket.getId() == 1)
			return 1;
		return 0;
	}
}
