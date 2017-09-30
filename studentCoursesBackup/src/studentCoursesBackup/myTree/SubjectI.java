package studentCoursesBackup.myTree;

public interface SubjectI {
    public void registerObserver(Node node_orig, Node backup_node_1, Node backup_node_2);

    public void removeObserver(Node node_orig);

    public void notifyAll(Node node_orig, String cName);
}
