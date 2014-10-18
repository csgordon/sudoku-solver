package sudoku;
import javax.swing.text.*;
import org.checkerframework.checker.guieffect.qual.*;

@UIType class FilteredDocument extends DocumentFilter  {
    int maxSize;

    // limit is the maximum number of characters allowed.
    public FilteredDocument(int limit) {
        maxSize = limit;
    }

    // This method is called when characters are inserted into the document
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String str,
            AttributeSet attr) throws BadLocationException {
        replace(fb, offset, 0, str, attr);
    }

    // This method is called when characters in the document are replace with other characters
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String str, AttributeSet attrs) throws BadLocationException {
        int newLength = fb.getDocument().getLength()-length+str.length();
        if (newLength <= maxSize) {
            fb.replace(offset, length, str, attrs);
        } else {
            java.awt.Toolkit.getDefaultToolkit().beep();
            throw new BadLocationException("New characters exceeds max size of document", offset);
            
        }
    }
}
