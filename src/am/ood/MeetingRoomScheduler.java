package am.ood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Here there are n given meeting rooms. Book a meeting in any meeting room at a
 * given interval(starting time, end time). Also send notifications to all
 * people who are invited for a meeting. You should use a calendar for tracking
 * date and time. And also history of all the meetings which are booked and
 * meeting room. write an API for the client who will give date and time and API
 * should return to the meeting room with booked scheduled time. the client
 * should also query for the history of the last 20 booked meetings. Is a
 * meeting room available? etc
 * 
 */
public class MeetingRoomScheduler {
	private static final int MAX_HISTORICAL_MEETING_STORAGE = 20;

	List<MeetingRoom> meetingRooms;
	Meeting[] history;
	int historySize;

	public MeetingRoomScheduler(List<MeetingRoom> rooms) {
		this.meetingRooms = rooms;
		this.history = new Meeting[MAX_HISTORICAL_MEETING_STORAGE];
		this.historySize = 0;
	}

	public Meeting book(Date start, Date end) throws Exception {
		try {
			for (MeetingRoom room : meetingRooms) {
				if (room.isAvailable(start, end)) {
					Meeting meeting = room.scheduleMeeting(start, end);
					saveToHistory(meeting);
					return meeting;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		throw new Exception();
	}

	private void saveToHistory(Meeting meeting) {
		if (historySize == MAX_HISTORICAL_MEETING_STORAGE) {
			history[0] = null;
			for (int i = 1; i < MAX_HISTORICAL_MEETING_STORAGE; i++) {
				history[i - 1] = history[i];
			}
		}

		history[historySize++] = meeting;
	}

	public void invite(Meeting meeting, List<Attendee> attendees) {
		meeting.invite(attendees);
	}

}

// An assumption here is that each meeting room has infinite capacity.
class MeetingRoom {
	Calendar calendar;

	public boolean isAvailable(Date start, Date end) {
		return calendar.checkAvailability(start, end);
	}

	public Meeting scheduleMeeting(Date start, Date end) {
		return calendar.scheduleNewMeeting(start, end);
	}
}

class Calendar {
	MeetingRoom room;
	List<Meeting> meetings;

	public Calendar() {
		this.meetings = new ArrayList<>();
	}

	public boolean checkAvailability(Date start, Date end) {
		for (Meeting meeting : meetings) {
			if (meeting.end.before(start) || meeting.start.after(end))
				return false;
		}
		return true;
	}

	public Meeting scheduleNewMeeting(Date start, Date end) {
		Meeting meeting = new Meeting(room, start, end);
		meetings.add(meeting);
		return meeting;
	}
}

class Meeting {
	int id;
	MeetingRoom location;
	List<Attendee> attendees;
	Date start;
	Date end;
	EmailService emailService;

	public Meeting(MeetingRoom location, Date start, Date end) {
		this.id = generateId();
		this.location = location;
		this.start = start;
		this.end = end;
		this.emailService = new EmailService();
	}

	private int generateId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Use AWS SES for transactional emails.
	 */
	public void invite(List<Attendee> attendees) {

	}
}

class EmailService {

}

class Attendee {
	String name;
	String email;
}
