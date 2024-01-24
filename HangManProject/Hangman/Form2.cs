using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Hangman
{
    
    public partial class Form2 : Form
    {
        public NewGame x;
        bool stasis;
        Form1 firstForm;
        public Form2(Form1 firstForm)
        {
            this.firstForm = firstForm;
            x = new NewGame();
            stasis = false;
            x.DisplayWord = String.Concat(Enumerable.Repeat("*", x.word.Length));
            InitializeComponent();
            label1.Text = x.DisplayWord;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void label1_Click(object sender, EventArgs e)
        {
            
        }


        private void Form2_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!stasis)
            {
                char guess = char.ToLower(e.KeyChar);
                if (char.IsLetter(guess))
                {
                    label1.Text = x.checkGuess(guess);
                    if (!x.DisplayWord.Contains('*'))
                    {
                        stasis = true;
                        Console.WriteLine("Game won!");
                        
                        firstForm.Score.Items.Add("1");
                    }
                    else if (x.guessesCount == 0)
                    {
                        stasis = true;
                        
                        firstForm.Score.Items.Add("0");
                    }
                    if (stasis)
                    {
                        firstForm.panel1.Visible = true;
                        this.Close();
                        MessageBox.Show($"The word was {x.word}\n");
                    }
                    label2.Text = $"You have {x.guessesCount} gueses left";
                    label3.Text = x.WrongGuesses;
                    Console.WriteLine(guess);
                }
            }else
            {
                Console.WriteLine("Game done");
            }
        }
    }

    public class NewGame
    {
        public ArrayList correctGuesses = new ArrayList();
        public ArrayList wrongGuesses = new ArrayList();
        public string WrongGuesses
        {
            get
            {
                StringBuilder sb = new StringBuilder();
                if (wrongGuesses.Count != 0)
                {
                    
                    sb.Append("Wrong guesses : ");
                    sb.Append(wrongGuesses[0]);
                    for (int i = 1; i < wrongGuesses.Count; i++)
                    {
                        sb.Append(" " + wrongGuesses[i]);
                    }
                }
                return sb.ToString();
            }
        }
        public int guessesCount = 10;

        private string displayWord;

        public string DisplayWord
        {
            get
            {
                StringBuilder sb = new StringBuilder();
                sb.Append(displayWord[0]);
                for (int i = 1; i < displayWord.Length; i++)
                {
                    sb.Append(" " +displayWord[i]) ;
                }

                return sb.ToString(); 
            }
            set {
                Console.WriteLine(value);
                displayWord =  value; }
        }

        public string word = "";
        public NewGame()
        {
            string[] words = new string[4];
            
            words[0] = "apple";
            words[1] = "english";
            words[2] = "afrikaans";
            words[3] = "cathedral";
            randomWord(words);
        }

        public void randomWord(string[] words)
        {
            Random rnd = new Random();
            Console.WriteLine(words);
            int num = rnd.Next(0, 4);

            word = words[num];
            Console.WriteLine(word);
        }


        public int guessesLeft()
        {
            return --guessesCount;
        }

        public void labelConversion(char letter)
        {
            char[] hold = displayWord.ToCharArray();
            for (int i = 0; i < word.Length; i++)
            {
                if (word.ToCharArray()[i] == letter)
                {
                    hold[i] = letter;
                }
                
            }

            DisplayWord = new string(hold);
        }

        public string checkGuess(char letter)
        {
            if (word.Contains(letter) && !correctGuesses.Contains(letter))
            {
                correctGuesses.Add(letter);
                labelConversion(letter);
            }
            else if (!wrongGuesses.Contains(letter))
            {
                wrongGuesses.Add(letter);
                guessesLeft();
            }
            return DisplayWord;
        }

        // contains then get the index position then conversion
        // List box for previous guesses.
        // show message (message box when you failed or passed and makes you return home showing the word. make input box read only.
        //fix up the score. guesses left will be the score.
    }
}
