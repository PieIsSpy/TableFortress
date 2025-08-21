package java.com.pieisspy.tablefortress.model.components;

/** This interface requires an object to implement
 *  methods related to its health component.
 *
 *  @author PieIsSpy
 *  @version 1.0
 */
public interface HealthComponent {
    /** This method lets the object take x amounts
     *  of damage.
     *
     * @param x the amount of damage to be taken
     */
    void takeDamage(int x);

    /** This method checks if the object is alive or not
     *
     * @return true if the object is alive, false otherwise
     */
    boolean isAlive();

    /** This method checks if the object has full health
     *  or not.
     *
     * @return true if the object has full health, false otherwise
     */
    boolean isFullHealth();
}
