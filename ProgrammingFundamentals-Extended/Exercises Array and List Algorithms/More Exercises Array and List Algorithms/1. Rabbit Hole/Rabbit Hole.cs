using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Rabbit_Hole
{
    class Program
    {
        static void Main(string[] args)
        {
            var text = Console.ReadLine().Split(' ').ToList();

            int energy = int.Parse(Console.ReadLine());

            string command = String.Empty;
            int damage = 0;
            bool isEnergy = true;

            for (int i = 0; i < text.Count; i++)
            {
                if (text[i].Contains("|"))
                {
                    string[] currentCommand = text[i].Split('|');
                    command = currentCommand[0];
                    damage = int.Parse(currentCommand[1]);

                    var changeIndex = 0;
                    switch (command)
                    {
                        case "Left":
                            changeIndex = LeftGo(damage, i,text.Count);
                            i = changeIndex;
                            energy -= damage;
                            if (energy <= 0)
                            {
                                Console.WriteLine("You are tired. You can't continue the mission.");
                                isEnergy = false;
                            }
                            
                            break;
                        case "Right":
                            changeIndex = RightGo(damage, i, text.Count);
                            i = changeIndex;
                            energy -= damage;
                            if (energy <= 0)
                            {
                                Console.WriteLine("You are tired. You can't continue the mission.");
                                isEnergy = false;
                            }
                            

                            break;
                        case "Bomb":
                            energy -= damage;
                            text.RemoveAt(i);
                            i = -1;
                            if (energy <= 0)
                            {
                                Console.WriteLine("You are dead due to bomb explosion!");
                                isEnergy = false;
                            }
                            

                            break;
                    }
                }
                else
                {
                    Console.WriteLine("You have 5 years to save Kennedy!");
                    break;
                }
                if (text[text.Count - 1] != "RabbitHole")
                {
                    text.RemoveAt(text.Count - 1);
                }

                text.Add("Bomb|" + energy);

                if (!isEnergy)
                {
                    break;

                }
            }
        }

        public static int LeftGo(int value,int indexCycle, int lengthList)
        {
            var changeIndexCycle = Math.Abs(value - indexCycle) % lengthList;
            return changeIndexCycle - 1;
        }

        public static int RightGo(int value, int indexCysle, int lengthList)
        {
            var withRightGo = value + indexCysle;
            var changeIndexCycle = 0;

            if (withRightGo > lengthList)
            {
                changeIndexCycle = withRightGo % lengthList;
            }
            else
            {
                changeIndexCycle = withRightGo;
            }

            return changeIndexCycle - 1;
        }
    }
}
