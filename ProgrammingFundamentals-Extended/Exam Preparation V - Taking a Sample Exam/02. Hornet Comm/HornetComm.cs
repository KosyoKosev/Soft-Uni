using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Hornet_Comm
{
    class HornetComm
    {
        static void Main(string[] args)
        {
            var messages = new List<string>();
            var broadcasts = new List<string>();

            var input = Console.ReadLine();

            while (input != "Hornet is Green")
            {
                var split = input.Split(new []{" <-> "}, StringSplitOptions.RemoveEmptyEntries);

                if (split.Length != 2)
                {
                    input = Console.ReadLine();
                    continue;
                }
                var firstQuery = split[0];
                var secondQuery = split[1];

                if (firstQuery.All(char.IsDigit) && secondQuery.All(char.IsLetterOrDigit))
                {
                    var reverceFirstQuery = new string(firstQuery.Reverse().ToArray());
                    messages.Add($"{reverceFirstQuery} -> {secondQuery}");
                }
                if (firstQuery.All(x => !char.IsDigit(x)) && secondQuery.All(char.IsLetterOrDigit))
                {
                    var toUperOrToLowerSecondQuery = new StringBuilder();

                    foreach (var symbol in secondQuery)
                    {
                        if (char.IsUpper(symbol))
                        {
                            toUperOrToLowerSecondQuery.Append(char.ToLower(symbol));
                        }else if (char.IsLower(symbol))
                        {
                            toUperOrToLowerSecondQuery.Append(char.ToUpper(symbol));
                        }
                        else
                        {
                            toUperOrToLowerSecondQuery.Append(symbol);
                        }
                    }

                    broadcasts.Add($"{toUperOrToLowerSecondQuery} -> {firstQuery}");
                }

                input = Console.ReadLine();
            }

            Console.WriteLine("Broadcasts:");
            Console.WriteLine(broadcasts.Any() ? string.Join(Environment.NewLine, broadcasts) : "None");
            Console.WriteLine("Messages:");
            Console.WriteLine(messages.Any() ? string.Join(Environment.NewLine , messages) : "None");
        }
    }
}
