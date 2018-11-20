using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.SoftUni_Karaoke
{
    class SoftUniKaraoke
    {
        static void Main(string[] args)
        {
            var singers = Console.ReadLine().Split(',').Select(x => x.Trim()).ToArray();
            var songs = Console.ReadLine().Split(',').Select(x => x.Trim()).ToArray();

            var singersAndAwards = new Dictionary<string,SortedSet<string>>();

            var input = Console.ReadLine();

            while (input != "dawn")
            {
                var split = input.Split(',').Select(x => x.Trim()).ToArray();

                var singer = split[0];
                var song = split[1];
                var award = split[2];

                if (singers.Contains(singer) && songs.Contains(song))
                {
                    if (!singersAndAwards.ContainsKey(singer))
                    {
                        singersAndAwards[singer] = new SortedSet<string>();
                    }

                    singersAndAwards[singer].Add(award);
                }

                input = Console.ReadLine();
            }

            singersAndAwards = singersAndAwards
                .OrderByDescending(x => x.Value.Count)
                .ToDictionary(x => x.Key, x => x.Value);

            if (singersAndAwards.Count == 0)
            {
                Console.WriteLine("No awards");
            }
            foreach (var singerAndAward in singersAndAwards)
            {
                var singer = singerAndAward.Key;
                var awards = singerAndAward.Value;

                Console.WriteLine($"{singer}: {awards.Count} awards");

                foreach (var award in awards)
                {
                    Console.WriteLine($"--{award}");
                }
            }
        }
    }
}
