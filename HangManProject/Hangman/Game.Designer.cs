
namespace Hangman
{
    partial class Game
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.mainMenuButton = new System.Windows.Forms.Button();
            this.HiddenWord = new System.Windows.Forms.Label();
            this.guessesLeft = new System.Windows.Forms.Label();
            this.incorrectLetters = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // mainMenuButton
            // 
            this.mainMenuButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.mainMenuButton.BackColor = System.Drawing.SystemColors.Control;
            this.mainMenuButton.Location = new System.Drawing.Point(702, 0);
            this.mainMenuButton.Name = "mainMenuButton";
            this.mainMenuButton.Size = new System.Drawing.Size(101, 40);
            this.mainMenuButton.TabIndex = 0;
            this.mainMenuButton.TabStop = false;
            this.mainMenuButton.Text = "Main Menu";
            this.mainMenuButton.UseVisualStyleBackColor = false;
            this.mainMenuButton.Click += new System.EventHandler(this.MainMenu_Click);
            // 
            // HiddenWord
            // 
            this.HiddenWord.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Left | System.Windows.Forms.AnchorStyles.Right)));
            this.HiddenWord.Font = new System.Drawing.Font("Microsoft Sans Serif", 26.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.HiddenWord.Location = new System.Drawing.Point(184, 159);
            this.HiddenWord.Name = "HiddenWord";
            this.HiddenWord.Size = new System.Drawing.Size(436, 39);
            this.HiddenWord.TabIndex = 2;
            this.HiddenWord.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // guessesLeft
            // 
            this.guessesLeft.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.guessesLeft.AutoSize = true;
            this.guessesLeft.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.guessesLeft.Location = new System.Drawing.Point(327, 88);
            this.guessesLeft.Name = "guessesLeft";
            this.guessesLeft.Size = new System.Drawing.Size(150, 16);
            this.guessesLeft.TabIndex = 3;
            this.guessesLeft.Text = "You have 10 gueses left";
            // 
            // incorrectLetters
            // 
            this.incorrectLetters.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.incorrectLetters.AutoSize = true;
            this.incorrectLetters.Location = new System.Drawing.Point(350, 301);
            this.incorrectLetters.Name = "incorrectLetters";
            this.incorrectLetters.Size = new System.Drawing.Size(0, 13);
            this.incorrectLetters.TabIndex = 4;
            // 
            // Game
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.incorrectLetters);
            this.Controls.Add(this.guessesLeft);
            this.Controls.Add(this.HiddenWord);
            this.Controls.Add(this.mainMenuButton);
            this.KeyPreview = true;
            this.MinimumSize = new System.Drawing.Size(816, 489);
            this.Name = "Game";
            this.Text = "Hangman";
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.Game_KeyPress);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button mainMenuButton;
        private System.Windows.Forms.Label HiddenWord;
        private System.Windows.Forms.Label guessesLeft;
        private System.Windows.Forms.Label incorrectLetters;
    }
}