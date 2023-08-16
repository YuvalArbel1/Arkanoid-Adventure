// 206945107 Yuval Arbel
package listeners;


/**
 * Counter class , to count blocks and balls.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class Counter {
    private int number;


    /**
     * constructor a new Counter.
     */
    public Counter() {
        this.number = 0;
    }

    /**
     * This function sets the number variable to the number passed in.
     *
     * @param number The number of the item in the list.
     */
    public void setNumber(int number) {
        this.number = number;
    }


    /**
     * This function add number to current count.
     *
     * @param number The number to increase the counter by.
     */
    public void increase(int number) {
        setNumber(this.number + number);
    }

    /**
     * This function subtract number from current count.
     *
     * @param number The number to decrease the counter by.
     */
    public void decrease(int number) {
        setNumber(this.number - number);
    }


    /**
     * This function returns the current count.
     *
     * @return The value of the number variable.
     */
    public int getValue() {
        return this.number;
    }
}
