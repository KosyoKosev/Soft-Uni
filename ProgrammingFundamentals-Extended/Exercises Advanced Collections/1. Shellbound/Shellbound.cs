using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Shellbound
{
    class Shellbound
    {
        static void Main(string[] args)
        {
            var regionsAndShells = new Dictionary<string, HashSet<int>>();

            var input = Console.ReadLine();

            while (input != "Aggregate")
            {
                string[] split = input.Split(' ');
                var key = split[0];
                var value = int.Parse(split[1]);

                AddShells(regionsAndShells, key, value);

                input = Console.ReadLine();
            }

            foreach (var region in regionsAndShells.Keys)
            {
                int sumShells = regionsAndShells[region].Sum();
                int averageShells = sumShells / regionsAndShells[region].Count;
                int giantShell = 0;


                if (regionsAndShells[region].Count <= 1)
                {
                    giantShell = sumShells;

                }
                else
                {
                    giantShell = sumShells - averageShells;

                }


                Console.WriteLine($"{region} -> {string.Join(", ", regionsAndShells[region])} ({giantShell})");

            }
        }

        private static void AddShells(Dictionary<string, HashSet<int>> dictionary, string key, int value)
        {
            if (!dictionary.ContainsKey(key))
            {
                dictionary[key] = new HashSet<int>();
            }
            dictionary[key].Add(value);
        }
    }
}
