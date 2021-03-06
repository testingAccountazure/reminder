package gr.cytech.chatreminderbot.rest.controlCases;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "reminder")
@NamedQueries({
        @NamedQuery(name = "reminder.findNextPendingReminder",
                query = "SELECT r FROM Reminder r WHERE r.when <= CURRENT_TIMESTAMP order by r.when"),
        @NamedQuery(name = "reminder.findNextReminder",
                query = "SELECT r FROM Reminder r order by r.when"),
        @NamedQuery(name = "reminder.findAll",
                query = "SELECT r from Reminder r"),
        @NamedQuery(name = "reminder.showReminders",
                query = "SELECT r from Reminder r where r.senderDisplayName "
                        + "like :userid order by r.when"),
        @NamedQuery(name = "reminder.findByUserAndReminderId",
                query = "SELECT r from Reminder r where r.senderDisplayName "
                        + "like :userId AND r.reminderId = :reminderId")
})
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminder_id", nullable = false)
    private int reminderId;

    @Column(name = "what", nullable = false)
    private String what;

    @Column(name = "whenTo", nullable = false)
    private ZonedDateTime when;

    @Column(name = "sender_displayName", nullable = false)
    private String senderDisplayName;

    @Column(name = "space_id", nullable = false)
    private String spaceId;

    @Column(name = "thread_id", nullable = false)
    private String threadId;

    @Column(name = "is_recurring")
    private boolean isRecuring;

    @Column(name = "full_text")
    private String fullText;

    @Column(name = "is_for_all")
    private boolean isForAll;

    public Reminder() {
    }

    public Reminder(String what, ZonedDateTime when, String senderDisplayName, String spaceId, String threadId) {
        this.what = what;
        this.when = when;
        this.senderDisplayName = senderDisplayName;
        this.spaceId = spaceId;
        this.threadId = threadId;
    }

    public int getReminderId() {
        return reminderId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public String getThreadId() {
        return threadId;
    }

    public String getSenderDisplayName() {
        return senderDisplayName;
    }

    public String getWhat() {
        return what;
    }

    public ZonedDateTime getWhen() {
        return when;
    }

    public boolean isRecuring() {
        return isRecuring;
    }

    public String getFullText() {
        return fullText;
    }

    public boolean isForAll() {
        return isForAll;
    }

    public void setForAll(boolean forAll) {
        isForAll = forAll;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public void setRecuring(boolean recuring) {
        isRecuring = recuring;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public void setWhen(ZonedDateTime when) {
        this.when = when;
    }

    public void setSenderDisplayName(String senderDisplayName) {
        this.senderDisplayName = senderDisplayName;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reminder reminder = (Reminder) o;
        return reminderId == reminder.reminderId
                && Objects.equals(what, reminder.what)
                && Objects.equals(when, reminder.when)
                && Objects.equals(senderDisplayName, reminder.senderDisplayName)
                && Objects.equals(spaceId, reminder.spaceId)
                && Objects.equals(threadId, reminder.threadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reminderId, what, when, senderDisplayName, spaceId, threadId);
    }
}
