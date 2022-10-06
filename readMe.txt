   _____   _____    _____     _____    ____  __ __               _____                                   __  ___  
  / ____| |  __ \  |  __ \   / ____|  |___ \/_ /_ |             / ____|                                 /_ |/ _ \ 
 | |      | |__) | | |__) | | |  __     __) || || |   ______   | |  __   _ __    ___    _   _   _ __     | | | | |
 | |      |  ___/  |  _  /  | | |_ |   |__ < | || |  |______|  | | |_ | | '__|  / _ \  | | | | | '_ \    | | | | |
 | |____  | |      | | \ \  | |__| |   ___) || || |            | |__| | | |    | (_) | | |_| | | |_) |   | | |_| |
  \_____| |_|      |_|  \_\  \_____|  |____/ |_||_|             \_____| |_|     \___/   \__,_| | .__/    |_|\___/ 
                                                                                               | |                
                                                                                               |_|

    _               _                                      _       _             ___               _     _                   ___         _
   /_\    ___  ___ (_)  __ _   _ _    _ __    ___   _ _   | |_    / |    ___    / __|  ___   _ _  | |_  (_)  _ _    __ _    | _ \  ___  | |  _  _   __ _   ___   _ _    ___
  / _ \  (_-< (_-< | | / _` | | ' \  | '  \  / -_) | ' \  |  _|   | |   |___|   \__ \ / _ \ | '_| |  _| | | | ' \  / _` |   |  _/ / _ \ | | | || | / _` | / _ \ | ' \  (_-<
 /_/ \_\ /__/ /__/ |_| \__, | |_||_| |_|_|_| \___| |_||_|  \__|   |_|           |___/ \___/ |_|    \__| |_| |_||_| \__, |   |_|   \___/ |_|  \_, | \__, | \___/ |_||_| /__/
                       |___/                                                                                       |___/                     |__/  |___/

  _  _    ___   __      __    _____    ___      ___   _   _   _  _
 | || |  / _ \  \ \    / /   |_   _|  / _ \    | _ \ | | | | | \| |
 | __ | | (_) |  \ \/\/ /      | |   | (_) |   |   / | |_| | | .` |
 |_||_|  \___/    \_/\_/       |_|    \___/    |_|_\  \___/  |_|\_|

-- This program must be run in a folder structure as shown below:
.
├── res
│   └── <your shapes file>.txt
└── Sort.jar

-- In a terminal window, run the following command in the above directory:
java -jar Sort.jar <command arguments>

-- You must specify a filename compare type, and sort type using this format:
-f<filename> -t<compare type> -s<sort type>

-- Valid compare types:
    H for height
    V for volume
    A for base area

-- Valid sort types:
    B for bubble
    S for selection
    I for insertion
    M for merge
    Q for quick
    Z for bogo
