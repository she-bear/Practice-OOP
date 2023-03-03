package lesson5;

import java.util.*;

public class RobotGameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Приветствуем пользователя и объясняем, куда он попал

        System.out.println("Введите размеры карты:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        final RobotMap map = new RobotMap(n, m);
        System.out.println("Карта успешно создана");

        final CommandManager manager = new CommandManager(map);
        while (true) {
            System.out.println("""
                    Доступные действия:
                    1. Для создания робота введите create x y, где x и y - координаты для нового робота
                    2. Для вывода списка всех созданных роботов, введите list
                    3. Для перемещения робота введите move id, где id - идентификатор робота
                    4. Для изменения направления введите changedir id DIRECTION, где id - идентификатор робота, DIRECTION - одно из значений {TOP, RIGHT, BOTTOM, LEFT}
                    5. Для удаления робота введите delete id, где id - идентификатор робота
                    6. Для выхода напишите exit
                    ... список будет пополняться
                    """);

            String command = sc.nextLine();
            manager.acceptCommand(command);
        }

        // TODO: 24.02.2023 Домашнее задание:
        //  1. Разобраться с проектом
        //  2. Реализовать пункты 4 и 5 для действий пользователя
    }

    // менеджер для обработки команд (инкапсуляция обработки команд в одном компоненте)
    private static class CommandManager {

        private final RobotMap map;
        // список команд
        private final List<CommandHandler> handlers;

        public CommandManager(RobotMap map) {
            this.map = map;
            // список доступных команд
            handlers = new ArrayList<>();
            initHandlers();
        }

        // на каждую команду будет новый объект, который отвечает только за свою команду
        private void initHandlers() {
            initCreateCommandHandler();
            initListCommandHandler();
            initMoveCommandHandler();
            initDeleteCommandHandler();
            initExitCommandHandler();
        }

        private void initExitCommandHandler() {
            handlers.add(new CommandHandler(){
                @Override
                public String name() {
                    return "exit";
                }

                @Override
                public void runCommand(String[] args) {
                    System.exit(0);
                }
            });
        }

        private void initCreateCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "create";
                }

                // конкретная реализация метода runCommand, объявленная в интерфейсе
                // отвечает за запуск команды и у него есть доступ к аргументам
                // те handlers кому аргументы не нужны - этот параметр проигнорируют
                @Override
                public void runCommand(String[] args) {
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);
                    RobotMap.Robot robot = map.createRobot(new Point(x, y));
                    System.out.println("Робот " + robot + " успешно создан");
                }
            });
        }

        private void initListCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "list";
                }

                @Override
                public void runCommand(String[] args) {
                    map.acceptRobots(System.out::println);
                        //        map.acceptRobots(robot -> System.out.println(robot));
                        //        map.acceptRobots(new Consumer<RobotMap.Robot>() {
                        //            @Override
                        //            public void accept(RobotMap.Robot robot) {
                        //                System.out.println(robot);
                        //            }
                        //        });
                }
            });
        }

        private void initMoveCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "move";
                }

                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<RobotMap.Robot> robot = map.getById(robotId);
                    robot.ifPresentOrElse(RobotMap.Robot::move, () -> System.out.println("Робот с идентификатором " + robotId + " не найден"));

//                    if (robot.isPresent()) {
//                        RobotMap.Robot value = robot.get();
//                        value.move();
//                    } else {
//                        System.out.println("Робот с идентификатором " + robotId + " не найден")
//                    }
                }
            });
        }

        private void initDeleteCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "delete";
                }

                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);

                    if (map.deleteByID(robotId)) {
                        System.out.println("Робот с идентификатором " + robotId + " успешно удалён");
                    } else {
                        System.out.println("Робот с идентификатором " + robotId + " не найден");
                    }
                }
            });
        }

        public void acceptCommand(String command) {
            String[] split = command.split(" ");
            String commandName = split[0];
            // указываем, что мы копируем со split - начиная с первого аргумента и заканчивая последним (аргумент [0] - команда)
            String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);

            // по имени команды находится нужный handler и запускается
            boolean found = false; // флаг, что команда найдена  
            for (CommandHandler handler : handlers) {
                if (commandName.equals(handler.name())) {
                    found = true;
                    try {
                        handler.runCommand(commandArgs);
                    } catch (Exception e) {
                        System.err.println("Во время обработки команды \"" + commandName + "\" произошла ошибка: " + e.getMessage());
                    }
                }
            }

            if (!found) {
                System.out.println("Команда не найдена");
            }
        }

        // интерфейс для команд???
        private interface CommandHandler {
            String name();
            void runCommand(String[] args);
        }
    }
}
