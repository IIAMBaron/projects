
namespace Hangman
{
    partial class MainMenu
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
            this.exitButton = new System.Windows.Forms.Button();
            this.newGameButton = new System.Windows.Forms.Button();
            this.ScoreBoard = new System.Windows.Forms.ListBox();
            this.labelScoreBoard = new System.Windows.Forms.Label();
            this.Hangman = new System.Windows.Forms.Label();
            this.fileSystemWatcher1 = new System.IO.FileSystemWatcher();
            this.scoreBoardPanel = new System.Windows.Forms.Panel();
            ((System.ComponentModel.ISupportInitialize)(this.fileSystemWatcher1)).BeginInit();
            this.scoreBoardPanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // exitButton
            // 
            this.exitButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.exitButton.AutoSize = true;
            this.exitButton.Location = new System.Drawing.Point(711, 0);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(89, 37);
            this.exitButton.TabIndex = 0;
            this.exitButton.Text = "Exit";
            this.exitButton.UseVisualStyleBackColor = true;
            this.exitButton.Click += new System.EventHandler(this.exitGame_Click);
            // 
            // newGameButton
            // 
            this.newGameButton.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.newGameButton.Location = new System.Drawing.Point(339, 320);
            this.newGameButton.Name = "newGameButton";
            this.newGameButton.Size = new System.Drawing.Size(96, 42);
            this.newGameButton.TabIndex = 1;
            this.newGameButton.Text = "New Game";
            this.newGameButton.UseVisualStyleBackColor = true;
            this.newGameButton.Click += new System.EventHandler(this.newGame);
            // 
            // ScoreBoard
            // 
            this.ScoreBoard.FormattingEnabled = true;
            this.ScoreBoard.Location = new System.Drawing.Point(3, 40);
            this.ScoreBoard.Name = "ScoreBoard";
            this.ScoreBoard.Size = new System.Drawing.Size(174, 355);
            this.ScoreBoard.TabIndex = 3;
            // 
            // labelScoreBoard
            // 
            this.labelScoreBoard.AutoSize = true;
            this.labelScoreBoard.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelScoreBoard.Location = new System.Drawing.Point(3, 11);
            this.labelScoreBoard.Name = "labelScoreBoard";
            this.labelScoreBoard.Size = new System.Drawing.Size(103, 16);
            this.labelScoreBoard.TabIndex = 4;
            this.labelScoreBoard.Text = "SCOREBOARD";
            // 
            // Hangman
            // 
            this.Hangman.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.Hangman.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.Hangman.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Hangman.Location = new System.Drawing.Point(308, 172);
            this.Hangman.Name = "Hangman";
            this.Hangman.Size = new System.Drawing.Size(183, 37);
            this.Hangman.TabIndex = 5;
            this.Hangman.Text = "HANGMAN";
            this.Hangman.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // fileSystemWatcher1
            // 
            this.fileSystemWatcher1.EnableRaisingEvents = true;
            this.fileSystemWatcher1.SynchronizingObject = this;
            this.fileSystemWatcher1.Changed += new System.IO.FileSystemEventHandler(this.fileSystemWatcher1_Changed);
            // 
            // scoreBoardPanel
            // 
            this.scoreBoardPanel.Controls.Add(this.ScoreBoard);
            this.scoreBoardPanel.Controls.Add(this.labelScoreBoard);
            this.scoreBoardPanel.Location = new System.Drawing.Point(12, 43);
            this.scoreBoardPanel.Name = "scoreBoardPanel";
            this.scoreBoardPanel.Size = new System.Drawing.Size(218, 395);
            this.scoreBoardPanel.TabIndex = 6;
            // 
            // MainMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.scoreBoardPanel);
            this.Controls.Add(this.Hangman);
            this.Controls.Add(this.newGameButton);
            this.Controls.Add(this.exitButton);
            this.MinimumSize = new System.Drawing.Size(816, 489);
            this.Name = "MainMenu";
            this.Text = "Main Menu";
            this.Load += new System.EventHandler(this.MainMenu_Load);
            ((System.ComponentModel.ISupportInitialize)(this.fileSystemWatcher1)).EndInit();
            this.scoreBoardPanel.ResumeLayout(false);
            this.scoreBoardPanel.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button exitButton;
        private System.Windows.Forms.Button newGameButton;
        public System.Windows.Forms.ListBox ScoreBoard;
        private System.Windows.Forms.Label labelScoreBoard;
        private System.Windows.Forms.Label Hangman;
        private System.IO.FileSystemWatcher fileSystemWatcher1;
        public System.Windows.Forms.Panel scoreBoardPanel;
    }
}

