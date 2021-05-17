package models.users;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_session")
public class UserSession {

    @Id
    @Column(name="user_session_id")
    int userSessionID;

    @Column(name="session_uuid")
    UUID sessionUUID;

    @Column(name="start")
    LocalDateTime start;

    @Column(name="last_active")
    LocalDateTime lastActive;

    @Column(name="client_ip")
    String clientIP;

    @Column(name="user_id")
    int userID;

    @Column(name="session_status")
    String sessionStatus;


    public UserSession() {

        this.userSessionID = 0;
        this.sessionUUID = UUID.randomUUID();
        this.start = LocalDateTime.now();
        this.lastActive = LocalDateTime.now();
        this.clientIP = "";
        this.userID = 0;
        this.sessionStatus = "online";

    }

    public UserSession(int userID, String clientIP) {

        this.userSessionID = 0;
        this.sessionUUID = UUID.randomUUID();
        this.start = LocalDateTime.now();
        this.lastActive = LocalDateTime.now();
        this.clientIP = clientIP;
        this.userID = userID;
        this.sessionStatus = "online";

    }

    public UserSession(int userSessionID, int sessionUUID, LocalDateTime start, LocalDateTime lastActive, String clientIP, int userID, String sessionStatus) {
       
        this.userSessionID = userSessionID;
        this.sessionUUID =  UUID.randomUUID();;
        this.start = start;
        this.lastActive = lastActive;
        this.clientIP = clientIP;
        this.userID = userID;
        this.sessionStatus = sessionStatus;
    }

    public UserSession(UserSession userSession) {

        this.userSessionID = userSession.userSessionID;
        this.sessionUUID = UUID.randomUUID();
        this.start = userSession.start;
        this.lastActive = userSession.lastActive;
        this.clientIP = userSession.clientIP;
        this.userID = userSession.userID;
        this.sessionStatus = userSession.sessionStatus;
    }


    public int getUserSessionID() {
        return this.userSessionID;
    }

    public void setUserSessionID(int userSessionID) {
        this.userSessionID = userSessionID;
    }

    public UUID getSessionUUID() {
        return this.sessionUUID;
    }

    public void setSessionUUID(UUID sessionUUID) {
        this.sessionUUID = sessionUUID;
    }

    public LocalDateTime getStart() {
        return this.start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getLastActive() {
        return this.lastActive;
    }

    public void setLastActive(LocalDateTime lastActive) {
        this.lastActive = lastActive;
    }

    public String getClientIP() {
        return this.clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSessionStatus() {
        return this.sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public UserSession userSessionID(int userSessionID) {
        setUserSessionID(userSessionID);
        return this;
    }

    public UserSession sessionUUID(UUID sessionUUID) {
        setSessionUUID(sessionUUID);
        return this;
    }

    public UserSession start(LocalDateTime start) {
        setStart(start);
        return this;
    }

    public UserSession lastActive(LocalDateTime lastActive) {
        setLastActive(lastActive);
        return this;
    }

    public UserSession clientIP(String clientIP) {
        setClientIP(clientIP);
        return this;
    }

    public UserSession userID(int userID) {
        setUserID(userID);
        return this;
    }

    public UserSession sessionStatus(String sessionStatus) {
        setSessionStatus(sessionStatus);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserSession)) {
            return false;
        }
        UserSession userSession = (UserSession) o;
        return userSessionID == userSession.userSessionID && Objects.equals(sessionUUID, userSession.sessionUUID) && Objects.equals(start, userSession.start) && Objects.equals(lastActive, userSession.lastActive) && Objects.equals(clientIP, userSession.clientIP) && userID == userSession.userID && Objects.equals(sessionStatus, userSession.sessionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSessionID, sessionUUID, start, lastActive, clientIP, userID, sessionStatus);
    }

    @Override
    public String toString() {
        return "{" +
            " userSessionID='" + getUserSessionID() + "'" +
            ", sessionUUID='" + getSessionUUID() + "'" +
            ", start='" + getStart() + "'" +
            ", lastActive='" + getLastActive() + "'" +
            ", clientIP='" + getClientIP() + "'" +
            ", userID='" + getUserID() + "'" +
            ", sessionStatus='" + getSessionStatus() + "'" +
            "}";
    }

}