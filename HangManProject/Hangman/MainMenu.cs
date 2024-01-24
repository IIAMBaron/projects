/*
 * Filename: MainMenu.cs
 * Name: Liam Baron
 * Created: 08/12/2023
 * Operating System: Windows 10
 * Version: Visual Studio 2019
 * Description: This file will handle the main menu interactions and it also creates
 * the game form where the game takes place
 */
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
    /*
     * Date: 08/12/2023
     * Author: Liam Baron
     * Purpose: This is the Main Menu of the game, and this holds the scoreboard information and the ability to exit the
     * application
     */
    public partial class MainMenu : Form
    {
        // This will give us the ability to create a form
        Game secondForm;
        // This is being used in the second form meaning that the scores will be available until the appllicaiton is closed
        public SortedList score = new SortedList();
        public MainMenu()
        {
            InitializeComponent();
        }

        private void fileSystemWatcher1_Changed(object sender, System.IO.FileSystemEventArgs e)
        {

        }

        private void exitGame_Click(object sender, EventArgs e)
        {
            // The application will exit with this method
            Application.Exit();
        }

        private void newGame(object sender, EventArgs e)
        {
            // Creating a new form that will be able to play the game
            secondForm = new Game(this);
            secondForm.Show();
        }

        private void MainMenu_Load(object sender, EventArgs e)
        {
            // This makes sure the scoreboard is not visible until a game has been played
            scoreBoardPanel.Visible = false;
        }
    }
}
