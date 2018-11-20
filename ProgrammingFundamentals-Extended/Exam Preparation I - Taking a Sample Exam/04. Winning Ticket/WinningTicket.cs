using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04.Winning_Ticket
{
    class WinningTicket
    {
        static void Main(string[] args)
        {
            var pattern = @"([@#$^])\1{5,}";

            var regexTicket = new Regex(pattern);

            var tickets = Console.ReadLine().Split(',').Select(x => x.Trim()).ToArray();

            foreach (var ticket in tickets)
            {
                if (ticket.Length != 20)
                {
                    Console.WriteLine("invalid ticket");
                }
                else
                {
                    var leftHalf = ticket.Substring(0, ticket.Length / 2);
                    var rightHalf = ticket.Substring(ticket.Length / 2);

                    var leftMatch = regexTicket.Match(leftHalf);
                    var rightMatch = regexTicket.Match(rightHalf);
                    
                    if (leftMatch.Success && rightMatch.Success)
                    {
                        if (leftMatch.Length == 10 && rightMatch.Length == 10)
                        {
                            Console.WriteLine($"ticket \"{ticket}\" - {Math.Min(leftMatch.Length,rightMatch.Length)}{leftMatch.Value[0]} Jackpot!");
                        }
                        else
                        {
                            Console.WriteLine($"ticket \"{ticket}\" - {Math.Min(leftMatch.Length, rightMatch.Length)}{leftMatch.Value[0]}");
                        }
                    }
                    else
                    {
                        Console.WriteLine($"ticket \"{ticket}\" - no match");
                    }
                }
            }
        }
    }
}
