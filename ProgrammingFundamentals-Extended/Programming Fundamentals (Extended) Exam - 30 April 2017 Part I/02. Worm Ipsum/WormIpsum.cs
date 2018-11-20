using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _02.Worm_Ipsum
{
    class WormIpsum
    {
        static void Main(string[] args)
        {
            var change = new List<List<string>>();
            var changewords = new List<string>();
            var input = Console.ReadLine();
            
            var words = new List<string>();

            while (input != "Worm Ipsum")
            {
                var regex = new Regex(@"\.");
                var matches = regex.Matches(input);

                if (matches.Count > 1)
                {
                    input = Console.ReadLine();
                    continue;
                }

                var split = input.Split(new[] {' ', '-', '.'}, StringSplitOptions.RemoveEmptyEntries);

                for (int i = 0; i < split.Length; i++)
                {
                    words.Add(split[i]);
                }

                for (int i = 0 ;i < words.Count; i++)
                {
                    
                    var changeWord = "";
                    var symbolMax = new Dictionary<char, int>();

                    foreach (var symbol in words[i])
                    {
                         if (!symbolMax.ContainsKey(symbol))
                        {
                            symbolMax[symbol] = 0;
                        }
                        symbolMax[symbol]++;
                    }

                    var maxSymbol = symbolMax.OrderByDescending(x => x.Value).Take(1).ToDictionary(x => x.Key, x => x.Value);

                    var symbolChenge = maxSymbol.Keys.ToArray();
                    var max = maxSymbol.Values.ToArray();
                    if (max[0] == 1)
                    {
                        changeWord = words[i];
                        
                    }
                    else
                    {
                        foreach (var symbol in words[i])
                        {

                            if (symbol != symbolChenge[0] || symbol == symbolChenge[0])
                            {
                                changeWord += symbolChenge[0];
                            }
                            
                        }
                    }
                    changewords.Add(changeWord);

                }
                Console.WriteLine($"{string.Join(" ",changewords).Trim()}.");
                words = new List<string>();
                changewords = new List<string>();
                input = Console.ReadLine();
            }
        }
    }
}
