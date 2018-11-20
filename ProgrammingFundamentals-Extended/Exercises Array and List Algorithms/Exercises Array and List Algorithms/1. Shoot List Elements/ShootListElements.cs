using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Shoot_List_Elements
{
    class ShootListElements
    {
        static void Main(string[] args)
        {
            var numbers = new List<int>();
            int counter = 0;
            int lastElement = 0;
            bool isOutList = false;

            var command = Console.ReadLine();

            while (command != "stop")
            {
                int number;
                bool isNumber = Int32.TryParse(command, out number);
                
                if (isNumber)
                {
                    number = int.Parse(command);
                    numbers.Insert(0, number);
                }

                if (command.Equals("bang"))
                {
                    if (counter < 0)
                    {
                        isOutList = true;
                        break;
                    }
                    counter = numbers.Count - 1;
                    double average = numbers.Average();
                    
                    for (int i = 0; i < numbers.Count; i++)
                    {
                        if (average >= numbers[i])
                        {
                            lastElement = numbers[i];
                            numbers.RemoveAt(i);
                            counter--;
                            Console.WriteLine($"shot {lastElement}");

                            for (int j = 0; j < numbers.Count; j++)
                            {
                                numbers[j] -= 1;
                            }
                            break;
                        }
                    }
                }

                if (isOutList)
                {
                    break;
                }

                command = Console.ReadLine();
            }
            if (isOutList)
            {
                Console.WriteLine($"nobody left to shoot! last one was {lastElement}");
            }
            else if (counter + 1 == 0)
            {
                Console.WriteLine($"you shot them all. last one was {lastElement}");
            }
            else
            {
                Console.WriteLine($"survivors: {string.Join(" ", numbers)}");
            }
        }

        
    }
}
