using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Letter_Repetition
{
    class LetterRepetition
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();

            var statistic = new Dictionary<char, int>();

            foreach (var symbol in text)
            {
                if (!statistic.ContainsKey(symbol))
                {
                    statistic.Add(symbol, 0);
                }

                statistic[symbol]++;

            }

            foreach (var kvp in statistic)
            {
                Console.WriteLine($"{kvp.Key} -> {kvp.Value}");
            }
        }
    }
}
