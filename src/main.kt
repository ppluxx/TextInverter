import java.awt.*
import java.awt.datatransfer.StringSelection
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JTextField
import javax.swing.UIManager

fun main() {
    // Janela
    val window = JFrame("Invertedor de coisas v2")
    window.setSize(600, 500)
    window.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    window.contentPane.background = Color.BLACK
    window.layout = FlowLayout()
    // Componentes da janela
    val label = JLabel("Escreva algo para o programa inverter")
    label.foreground = Color.WHITE
    label.font = Font("Arial", Font.BOLD, 32)
    val rawText = JTextField(25)
    rawText.foreground = Color.WHITE
    rawText.background = Color.BLACK
    rawText.font = Font("Arial", Font.PLAIN, 16)
    val button = JButton("Inverter")
    val copy = JButton("Copiar")
    // Script do botão
    UIManager.put("OptionPane.background", Color.DARK_GRAY)
    UIManager.put("Panel.background", Color.DARK_GRAY)
    UIManager.put("OptionPane.messageForeground", Color.WHITE)
    button.addActionListener{
        val cookedText = rawText.text?.reversed()
        JOptionPane.showMessageDialog(window, "$cookedText", "Texto invertido", -1)
    }
    copy.addActionListener{
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        val transferData = StringSelection(rawText.text?.reversed())
        clipboard.setContents(transferData, null)
    }
    // Adição dos mesmos na janela
    window.add(label)
    window.add(rawText)
    window.add(button)
    window.add(copy)
    // Janela sempre visível
    window.isVisible = true
}