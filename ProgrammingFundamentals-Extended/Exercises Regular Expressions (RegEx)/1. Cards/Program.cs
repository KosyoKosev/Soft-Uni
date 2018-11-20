using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _1.Cards
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();

            var pattern = @"(([23456789]|10)[SHDC])|([JQKA][SHDC])";

            var regex = new Regex(pattern);

            var validCards = new List<string>();

            var matches = regex.Matches(input);

            for (int i = 0; i < matches.Count; i++)
            {
                var number = 0;

                if (Int32.TryParse(matches[i], out number))
                
                {
                    
                }
            }
        }
    }
}
