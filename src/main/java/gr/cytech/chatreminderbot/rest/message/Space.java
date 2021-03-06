package gr.cytech.chatreminderbot.rest.message;

public class Space {
    private String spaceName;
    private String spaceDisplayName;
    private String spaceType;

    public Space(String spaceName, String spaceDisplayName, String spaceType) {
        this.spaceName = spaceName;
        this.spaceDisplayName = spaceDisplayName;
        this.spaceType = spaceType;
    }

    public Space() {
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceDisplayName() {
        return spaceDisplayName;
    }

    public void setSpaceDisplayName(String spaceDisplayName) {
        this.spaceDisplayName = spaceDisplayName;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }
}
