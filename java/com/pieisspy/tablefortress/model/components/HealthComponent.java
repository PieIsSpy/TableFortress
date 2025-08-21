package java.com.pieisspy.tablefortress.model.components;

public interface HealthComponent {
    void takeDamage(int x);
    boolean isAlive();
    boolean isFullHealth();
}
