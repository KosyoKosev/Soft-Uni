using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04.Worms_World_Party
{
    class WormsWorldParty
    {
        static void Main(string[] args)
        {
            var wormScores = new Dictionary<string, Dictionary<string, long>>();

            var input = Console.ReadLine();

            while (input != "quit")
            {
                var split = input.Split(new[] { '-', '>' }, StringSplitOptions.RemoveEmptyEntries);

                var wormName = split[0].Trim();
                var teamName = split[1].Trim();
                var wormScore = long.Parse(split[2]);

                if (!wormScores.ContainsKey(teamName))
                {
                    wormScores[teamName] = new Dictionary<string, long>();
                }
                if (!wormScores[teamName].ContainsKey(wormName))
                {
                    var count = 0;

                    foreach (var score in wormScores)
                    {
                        if (score.Value.ContainsKey(wormName))
                        {
                            count++;
                        }
                    }
                    if (count == 0)
                    {
                        wormScores[teamName][wormName] = wormScore;
                    }
                }

                input = Console.ReadLine();
            }


            foreach (var teams in wormScores)
            {
                if (teams.Value.Count == 0)
                {
                    wormScores.Remove(teams.Key);
                    break;
                }
            }




            var result = wormScores
                .OrderByDescending(x => x.Value.Values.Sum())
                .ThenByDescending(x => x.Value.Values.Average())
                .ToDictionary(x => x.Key, x => x.Value);

            var counter = 1;



            foreach (var team in result)
            {

                var teamTotal = team.Value.Values.Sum();
                Console.WriteLine($"{counter}. Team: {team.Key} - {teamTotal}");

                foreach (var wormName in team.Value.OrderByDescending(x => x.Value))
                {
                    Console.WriteLine($"###{wormName.Key} : {wormName.Value}");
                }

                counter++;
            }


        }
    }
}
