public class ReadNChars {
    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf);
     */

        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int currIndex = 0; // keeps track of where to put the latest read characters
            char buf4[] = new char[4]; // the buffer to retrieve values from the read4 function

            while (n > 0) { // if n <= 0, we have read enough
                int p = read4(buf4);  // read from the buffer

                int i = 0;                       // index for buf4 reading
                while (i < p && n!= 0) {         // we do not want to read beyond what read4 gave, or beyond what the api asked
                    buf[currIndex] = buf4[i];  // just copy
                    i++;                                     // increment index for buffer
                    n--;                                     // we read a character so n has decreased
                    currIndex++;                     // we have updated the buffer so increment
                }

                if (p < 4) break;  // this means we have read till the end of the file, so no more reading is possible
            }
            return currIndex;    // return the length read
        }



        public int read4(char[] buf) {
            return 1;
        }
    }
