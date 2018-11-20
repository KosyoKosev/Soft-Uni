using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Phonebook
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] phoneNumbers = Console.ReadLine().Split(' ');

            string[] names = Console.ReadLine().Split(' ');

            string command = Console.ReadLine();

            while (!(command.Equals("done")))
            {
                for (int i = 0; i < names.Length; i++)
                {
                    
                    if (command.Equals(names[i]))
                    {
                        Console.WriteLine($"{names[i]} -> {phoneNumbers[i]}");
                        break;
                    }
                }

               command = Console.ReadLine();
            }

            
        }
    }
}
