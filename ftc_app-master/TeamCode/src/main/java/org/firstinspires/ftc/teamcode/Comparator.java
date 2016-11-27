package org.firstinspires.ftc.teamcode;

/**
 * Created by Plotnw on 10/25/2016.
 */

public class Comparator {
        //Fairly simple object, to store the movement values. This will allow the grid functions to remain pure, and only have one impure function
        private long left;
        private long right;

        public Comparator(long left, long right) {
            this.left = left;
            this.right = right;
        }

        public Comparator(int left, int right) {
            this.left = (long) left;
            this.right = (long) right;
        }

        public long getLeft() { return left; }
        public long getRight() { return right; }
        public boolean compare(long i) {
            return (this.left < i && i < this.right);
        }
}
