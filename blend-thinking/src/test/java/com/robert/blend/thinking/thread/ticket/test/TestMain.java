package com.robert.blend.thinking.thread.ticket.test;

import com.robert.blend.thinking.thread.ticket.dao.TicketDaoImpl;
import com.robert.blend.thinking.thread.ticket.domain.Ticket;

public class TestMain {
	public static void main(String[] args) {
		final Ticket ticket = new Ticket();
		ticket.setId(1);
		final Ticket ticket1 = new Ticket();
		ticket1.setId(2);

		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					new TicketDaoImpl().sell(ticket);
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					new TicketDaoImpl().sell(ticket);
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					new TicketDaoImpl().sell(ticket1);
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					new TicketDaoImpl().sell(ticket1);
				}
			}).start();
		}
	}
}
