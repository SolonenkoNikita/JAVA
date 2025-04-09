package ru.npsolonenko;

/*
Когда в Scanner возникает исключение при вводе
(например, InputMismatchException или IOException),
он перехватывает это исключение, закрывает источник ввода (например, InputStream),
а затем повторно выбрасывает исходное исключение.
Это реализовано в методах типа next(), nextInt() и других.

Если при закрытии ресурса (в методе close()) возникнет новое исключение,
оно будет подавлено (added as a suppressed exception) к основному исключению,
которое возникло при операции ввода.

Это поведение соответствует спецификации try-with-resources,
даже если Scanner сам управляет закрытием ресурса без использования этого синтаксиса.
*/



public class Task7 {
}

/**
 * Closes this scanner.
 *
 * <p> If this scanner has not yet been closed then if its underlying
 * {@linkplain java.lang.Readable readable} also implements the {@link
 * java.io.Closeable} interface then the readable's {@code close} method
 * will be invoked.  If this scanner is already closed then invoking this
 * method will have no effect.
 *
 * <p>Attempting to perform search operations after a scanner has
 * been closed will result in an {@link IllegalStateException}.
 *
 */
    /*
    public void close() {
        if (closed)
            return;
        if (source instanceof Closeable) {
            try {
                ((Closeable)source).close();
            } catch (IOException ioe) {
                lastException = ioe;
            }
        }
        sourceClosed = true;
        source = null;
        closed = true;
    }*/

/**
 * Returns the {@code IOException} last thrown by this
 * {@code Scanner}'s underlying {@code Readable}. This method
 * returns {@code null} if no such exception exists.
 *
 * @return the last exception thrown by this scanner's readable
 */
    /*
    public IOException ioException() {
        return lastException;
    }*/


/*    // Tries to read more input. May block.
    private void readInput() {
        if (buf.limit() == buf.capacity())
            makeSpace();
        // Prepare to receive data
        int p = buf.position();
        buf.position(buf.limit());
        buf.limit(buf.capacity());

        int n = 0;
        try {
            n = source.read(buf);
        } catch (IOException ioe) {
            lastException = ioe;
            n = -1;
        }
        if (n == -1) {
            sourceClosed = true;
            needInput = false;
        }
        if (n > 0)
            needInput = false;
        // Restore current position and limit for reading
        buf.limit(buf.position());
        buf.position(p);
    }*/
