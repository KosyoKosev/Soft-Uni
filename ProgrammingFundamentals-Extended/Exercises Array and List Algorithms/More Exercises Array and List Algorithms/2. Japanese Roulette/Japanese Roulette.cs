using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Japanese_Roulette
{
    class Program
    {
        static void Main(string[] args)
        {
            var cylinder = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            var players = Console.ReadLine().Split(' ').ToList();

            string command = String.Empty;
            int powerRotation = 0;
            int firstPositionBullet = 0;
            int lastPositionBullet = 0;
            bool isDeath = false;

            for (int i = 0; i < cylinder.Count; i++)
            {
                
                if (cylinder[i] == 1)
                {
                    firstPositionBullet = i;
                }
            }

            for (int i = 0; i < players.Count; i++)
            {
                string[] commands = players[i].Split(',');
                command = commands[1];
                powerRotation = int.Parse(commands[0]);

                if (command == "Right")
                {
                    lastPositionBullet = (firstPositionBullet + powerRotation) % cylinder.Count;
                    firstPositionBullet = lastPositionBullet;
                }
                else
                {
                    lastPositionBullet = Math.Abs(powerRotation - firstPositionBullet) % cylinder.Count;
                    firstPositionBullet = lastPositionBullet;
                }

                if (lastPositionBullet == 2)
                {
                    Console.WriteLine($"Game over! Player {i} is dead.");
                    isDeath = true;
                    break;
                }
                firstPositionBullet++;
            }

            if (!isDeath)
            {
                Console.WriteLine("Everybody got lucky!");
            }
            
        }
    }
}
