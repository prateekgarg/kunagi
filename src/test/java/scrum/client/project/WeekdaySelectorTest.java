package scrum.client.project;

import ilarkesto.testng.ATest;

import org.testng.annotations.Test;

import scrum.client.common.WeekdaySelector;

public class WeekdaySelectorTest extends ATest {

	@Test
	public void none() {
		WeekdaySelector days = new WeekdaySelector(0);
		assertFalse(days.isSun());
		assertFalse(days.isMon());
		assertFalse(days.isTue());
		assertFalse(days.isWed());
		assertFalse(days.isThu());
		assertFalse(days.isFri());
		assertFalse(days.isSat());
	}

	@Test
	public void all() {
		WeekdaySelector days = new WeekdaySelector(0);
		days.setSun(true);
		days.setMon(true);
		days.setTue(true);
		days.setWed(true);
		days.setThu(true);
		days.setFri(true);
		days.setSat(true);
		int bitmask = days.createBitmask();
		assertEquals(bitmask, 127);
		days = new WeekdaySelector(bitmask);
		assertTrue(days.isSun());
		assertTrue(days.isMon());
		assertTrue(days.isTue());
		assertTrue(days.isWed());
		assertTrue(days.isThu());
		assertTrue(days.isFri());
		assertTrue(days.isSat());
	}

	@Test
	public void some() {
		WeekdaySelector days = new WeekdaySelector(0);
		days.setSun(true);
		days.setMon(false);
		days.setTue(false);
		days.setWed(true);
		days.setThu(false);
		days.setFri(false);
		days.setSat(true);
		int bitmask = days.createBitmask();
		assertEquals(bitmask, 73);
		days = new WeekdaySelector(bitmask);
		assertTrue(days.isSun());
		assertFalse(days.isMon());
		assertFalse(days.isTue());
		assertTrue(days.isWed());
		assertFalse(days.isThu());
		assertFalse(days.isFri());
		assertTrue(days.isSat());
	}

}
