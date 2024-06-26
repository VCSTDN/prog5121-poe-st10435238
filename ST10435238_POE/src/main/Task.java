package main;

public class Task {
    private static int taskCounter = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerName;
    private double taskDuration;
    private String taskId;
    private String taskStatus;

    public int countTeamMembers = 0; // Keep track of the number of team members
    public User[] teamMembers = new User[100]; // A list of User objects that are responsible for this task

    public Task(String taskName, String taskDescription, String developerName, double taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskId = createTaskID();
    }

    private String createTaskID() {
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String devInitials = developerName.substring(developerName.length() - 3).toUpperCase();
        return String.format("%s:%d:%s", taskInitials, taskNumber, devInitials);
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
        this.taskId = createTaskID(); // Update taskId when taskName changes
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription.length() > 50) {
            throw new IllegalArgumentException("Please enter a task description of less than 50 characters");
        }
        this.taskDescription = taskDescription;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
        this.taskId = createTaskID(); // Update taskId when developerName changes
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(double taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void addTeamMember(User user) {
        if (countTeamMembers < teamMembers.length) {
            teamMembers[countTeamMembers++] = user;
        } else {
            System.out.println("Cannot add more team members, array is full.");
        }
    }

    public void removeUserFromTask(String username) {
        for (int i = 0; i < countTeamMembers; i++) {
            if (teamMembers[i] != null && teamMembers[i].getUsername().equals(username)) {
                System.out.println("Removing " + username);
                teamMembers[i] = null;
                shiftTeamMembersLeft(i);
                countTeamMembers--;
                return;
            }
        }
        System.out.println("User " + username + " not found in the task.");
    }

    private void shiftTeamMembersLeft(int index) {
        for (int i = index; i < countTeamMembers - 1; i++) {
            teamMembers[i] = teamMembers[i + 1];
        }
        teamMembers[countTeamMembers - 1] = null;
    }
}
