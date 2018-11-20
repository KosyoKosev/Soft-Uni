using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Integer_Insertion
{
    class Program
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var command = Console.ReadLine();

            while (command != "end")
            {
                var commandToInt = int.Parse(command);

                if (commandToInt < 10 )
                {
                    numbers.Insert(commandToInt, commandToInt);
                }
                else
                {
                    int firstNumber = command[0] - '0';

                    numbers.Insert(firstNumber, commandToInt);
                }

                command = (Console.ReadLine());

            }

            Console.WriteLine(string.Join(" ",numbers));
        }
    }
}
