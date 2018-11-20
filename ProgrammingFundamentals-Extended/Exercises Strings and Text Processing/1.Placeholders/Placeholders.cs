using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Placeholders
{
    class Placeholders
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();

            while (input != "end")
            {
                var indexOfSwitch = input.IndexOf("->");
                var partOfTheInput = input.Substring(indexOfSwitch + 2).Split(new []{' ', ','},StringSplitOptions.RemoveEmptyEntries);

                input = input.Remove(indexOfSwitch);

                for (int i = 0; i < partOfTheInput.Length; i++)
                {
                    input = input.Replace("{" + i + "}", partOfTheInput[i]);
                }

                Console.WriteLine(input);

                input = Console.ReadLine();
            }
        }
    }
}
