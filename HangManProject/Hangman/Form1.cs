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
    public partial class Form1 : Form
    {
        Form2 secondForm;
        SortedList score = new SortedList();
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            panel1.Visible = false;
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            secondForm = new Form2(this);
            secondForm.Show();
            secondForm.FormClosing += new FormClosingEventHandler(Form2_FormClosing);
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void fileSystemWatcher1_Changed(object sender, System.IO.FileSystemEventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {
            
        }
        
        
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            Console.WriteLine("The first form has been closed.");
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            panel1.Visible = true;
            Console.WriteLine("The second form has been closed.");
            score.Add("9", "apple");
            Score.Items.Add("apple");
            Score.Items.Add("9");
        }

        private void Score_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
