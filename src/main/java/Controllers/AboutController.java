package Controllers;

import Global.UIManager;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AboutController extends Controller {

    public void AddFrog(){
        BasicWindow window = new BasicWindow("Żaba");
        Frog frogList = new Frog();
        Panel panel = Panels.vertical();
        AtomicBoolean shouldStop = new AtomicBoolean(false);
        Thread animation = new Thread(()->{
            while(true) {
                frogList.frogList.stream().forEachOrdered(frame ->{
                    panel.addComponent(frame);
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {}
                    panel.removeComponent(frame);
                });
                if(shouldStop.get()){
                    break;
                }
            }
        });
        animation.start();
        window.setHints(Arrays.asList(Window.Hint.CENTERED, Window.Hint.FIXED_SIZE));
        window.setFixedSize(new TerminalSize(79,43));
        window.setComponent(panel);
        UIManager.addWindow(window);
        panel.addComponent(new Button("Cofnij",()->{
            //zatrzymanie wątku
            shouldStop.set(true);
            animation.interrupt();
            GoBack();
        }));

    }
    private class Frog {
        public Frog(){
            frogList.add(label1);
            frogList.add(label2);
            frogList.add(label3);
            frogList.add(label4);
            frogList.add(label5);
            frogList.add(label6);
            frogList.add(label7);
            frogList.add(label8);
            frogList.add(label9);
        }

        public List<Label> frogList = new LinkedList<Label>();
        public Label label1 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                            ,DDDDDDDDDD88OO8NDD\n" +
                        "                         :IO8DNDDDDDD8DDD8OO888DD\n" +
                        "                    ,OOD88DDDD DDDD888DD8DD8OO8D4DD\n" +
                        "                  OO8DDDDN     DDD8888O8888D8OOO$8:DD\n" +
                        "                ZOO88DD       ,DD8888888888OO8888:DDDD7\n" +
                        "             :II$ZOD          :DD888888888D88ZNDO DDD7PD7\n" +
                        "            88NMM8            :DDDD88DDDDDD8888DZ   7:P7D3\n" +
                        "           D800NM:             DDDDDDDDDDDDDDDOOI     DDP2LP\n" +
                        "          OO88DDN,            ,DNDDDDDDDDDDDDD8O8O     CWFBVVRD\n" +
                        "         V7PDDDM7            =88DNNDNDDDDDNNNNDOO8D,      \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                           +DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                          IDDDNNNNMM=  /######D8OO888I\n" +
                        "                         :DNNNNNN,  /########/MD888888\n" +
                        "                        8DNMM      \\########/  +D8888D\n" +
                        "                       ODDNN           TT       D888DD\n" +
                        "                       888DDN          ||       PD88D$\n" +
                        "                        $D8D8NZ        ||       D8O8D,\n" +
                        "                          +888DN       ||       8OO8D\n" +
                        "                             88DN+    /||\\     OOODD\n" +
                        "                             ~DDML @@@@@@@@@@ 8OO8DN\n" +
                        "                              @@@@@@@@@@@@@@@@MN888\n" +
                        "                            @@@@@@#    #    #@P788O\n" +
                        "                           @@@@@   #   #   # 78O8@@@\n" +
                        "                          @@@@@     #  #  #  L888@@@@\n" +
                        "                         @@@@@       #000#  :DD88D@@@@\n" +
                        "                         @@@@########00000##OPO8D#@@@@\n" +
                        "                         @@@@@      # 000 # ZO8O,@@@@@\n" +
                        "                          @@@@@    #   #   :88N:@@@@@\n" +
                        "                           @@@@@  #    #  $OOD:@@@@@\n" +
                        "                             @@@@@@    #  N7Z8@@@@@\n" +
                        "                                @@@@@@@@@@DDM@@@\n" +
                        "                                   @@@@@@@@@@");

        public Label label2 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                            ,DDDDDDDDDD88OO8NDD\n" +
                        "                          :O8DNDDDDDD8DDD8OO888DDD:\n" +
                        "                       ,O8DDDD DDDD888DD8DD8OO8D4DDDDPD          \n" +
                        "                      :OO8DDN  DDD8888O8888D8OOO$8: ,OOD88DD\n" +
                        "                     ZO8DDN,  ,DD8888888888OO8888:     =OOOOO8DDN\n" +
                        "                   7IIIODM=   :DD888888888D88ZNDO          7POO88DDNN\n" +
                        "                  DMM8NMM     :DDDD88DDDDDD8888DZ              :P7D3DPDD\n" +
                        "                DDPLRWM        DDDDDDDDDDDDDDDOOI                 DPRMC777    \n" +
                        "               W77MDP8        ,DNDDDDDDDDDDDDD8O8O   \n" +
                        "             V7PDDDM7        =88DNNDNDDDDDNNNNDOO8D,          \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                           +DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                          IDDDNNNNMM=  /######D8OO888I\n" +
                        "                         :DNNNNNN,  /########/MD888888\n" +
                        "                         O8DNMM    \\########/ +8888DYD\n" +
                        "                         DODDN         TT     D888DD$\n" +
                        "                         $888D:        ||     DPD88D:\n" +
                        "                         $D8D8$        ||    DD8O8D,\n" +
                        "                         $88DN         ||    88OO8D\n" +
                        "                          8DNF+       /||\\   :OOODD\n" +
                        "                          $DMLW    @@@@@@@@@@ 8OO8D\n" +
                        "                           DTRD @@@@@@@@@@@@@@@MMN88\n" +
                        "                            @@@@@@#      #   @@@P788:\n" +
                        "                           @@@@@$  #    #    # @@78O8 \n" +
                        "                          @@@@@R#   #  #   #    @@8DO:\n" +
                        "                         @@@@@GPN #  #000#       @@@@@\n" +
                        "                         @@@@ DWPG  #00000## # # #@@@@\n" +
                        "                         @@@@@#08DN# #000  #     @@@@@\n" +
                        "                          @@@@@ 8DN#    #   #   @@@@@\n" +
                        "                           @@@@@ PDC   #     # @@@@@\n" +
                        "                             @@@@@@ND #      @@@@@@\n" +
                        "                                @@@@@@@@@@DDM@@@\n" +
                        "                                   @@@@@@@@@@");
        public Label label3 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                          ,DDDDDDDDDDDD88OO8NDD\n" +
                        "                      .DD:IO8DNDDDDDD8DDD8OO888DD\n" +
                        "                  ,DDOOD88DD   DDDD888DD8DD8OO8D4DD\n" +
                        "            .PDOOOOO8DDDDN     DDD8888O8888D8OOO$8:DD\n" +
                        "        DPZOO88DDN,           ,DD8888888888OO8888:DDDD7\n" +
                        "       DDDCDPTR               :DD888888888D88ZNDO  DDD7PD7\n" +
                        "                              :DDDD88DDDDDD8888DZ    7:P7D3\n" +
                        "                               DDDDDDDDDDDDDDDOOI       DDP2L\n" +
                        "                              ,DNDDDDDDDDDDDDD8O8O        77KV:\n" +
                        "                             =88DNNDNDDDDDNNNNDOO8D,      CWFBVVRD        \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                            DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                           :DDNNNNMM=  /######D8OO888\n" +
                        "                           DNNNNNND /########/MD88888\n" +
                        "                           DDOONM  \\########/DD88888\n" +
                        "                           8DHORO      TT   DD888DD\n" +
                        "                          :DPPOO:      ||  OPD888$\n" +
                        "                          8DNNEMP      || MD8DPPO\n" +
                        "                           RMMN8P      ||ND8OO88\n" +
                        "                            :GJMNBD   /|NNO8DD \n" +
                        "                             PRBBO@@@NDNNNNOD \n" +
                        "                              @@@@@@RGDNNMRO@@@@@ \n" +
                        "                            @@@@@@CRPNNNNNM #@@@@@@   \n" +
                        "                           @@@@@#  NNNNMPO #   @@@@@\n" +
                        "                          @@@@@  #NNMNNDP8PRD   @@@@@\n" +
                        "                         @@@@@   NNN8N000 DPMPDO @@@@@\n" +
                        "                         @@@@# #DNMCR00000#  MNDDG@@@@\n" +
                        "                         @@@@@ PON88  000#   # ND@@@@@\n" +
                        "                          @@@@@DDDNM  #   #    #@@@@@\n" +
                        "                           @@@@@DOM  #     #   @@@@@\n" +
                        "                             @@@@@@ #       #@@@@@@\n" +
                        "                                @@@@@@@@@@@@@@@@\n" +
                        "                                   @@@@@@@@@@\n");

        public Label label4 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                            ,DDDDDDDDDD88OO8NDD\n" +
                        "                         :IO8DNDDDDDD8DDD8OO888DD\n" +
                        "                    ,OOD88DDDD DDDD888DD8DD8OO8D4DD\n" +
                        "                  OO8DDDDN     DDD8888O8888D8OOO$8:DD\n" +
                        "                ZOO88DD       ,DD8888888888OO8888:DDDD7\n" +
                        "             :II$ZOD          :DD888888888D88ZNDO DDD7PD7\n" +
                        "            88NMM8            :DDDD88DDDDDD8888DZ   7:P7D3\n" +
                        "           D800NM:             DDDDDDDDDDDDDDDOOI     DDP2LP\n" +
                        "          OO88DDN,            ,DNDDDDDDDDDDDDD8O8O     CWFBVVRD\n" +
                        "         V7PDDDM7            =88DNNDNDDDDDNNNNDOO8D,      \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                           +DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                          IDDDNNNNMM=  /######D8OO888I\n" +
                        "                         :DNNNNNN,  /########/MD888888\n" +
                        "                        8DNMM      \\########/  +D8888D\n" +
                        "                       ODDNN           TT       D888DD\n" +
                        "                       888DDN          ||       PD88D$\n" +
                        "                        $D8D8NZ        ||       D8O8D,\n" +
                        "                          +888DN       ||       8OO8D\n" +
                        "                             88DN+    /||\\     OOODD\n" +
                        "                             ~DDML @@@@@@@@@@ 8OO8DN\n" +
                        "                              @@@@@@@@@@@@@@@@MN888\n" +
                        "                            @@@@@@#    #    #@P788O\n" +
                        "                           @@@@@   #   #   # 78O8@@@\n" +
                        "                          @@@@@     #  #  #  L888@@@@\n" +
                        "                         @@@@@       #000#  :DD88D@@@@\n" +
                        "                         @@@@########00000##OPO8D#@@@@\n" +
                        "                         @@@@@      # 000 # ZO8O,@@@@@\n" +
                        "                          @@@@@    #   #   :88N:@@@@@\n" +
                        "                           @@@@@  #    #  $OOD:@@@@@\n" +
                        "                             @@@@@@    #  N7Z8@@@@@\n" +
                        "                                @@@@@@@@@@DDM@@@\n" +
                        "                                   @@@@@@@@@@");

        public Label label5 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                            ,DDDDDDDDDD88OO8NDD\n" +
                        "                          :O8DNDDDDDD8DDD8OO888DDD:\n" +
                        "                       ,O8DDDD DDDD888DD8DD8OO8D4DDDDPD          \n" +
                        "                      :OO8DDN  DDD8888O8888D8OOO$8: ,OOD88DD\n" +
                        "                     ZO8DDN,  ,DD8888888888OO8888:     =OOOOO8DDN\n" +
                        "                   7IIIODM=   :DD888888888D88ZNDO          7POO88DDNN\n" +
                        "                  DMM8NMM     :DDDD88DDDDDD8888DZ              :P7D3DPDD\n" +
                        "                DDPLRWM        DDDDDDDDDDDDDDDOOI                 DPRMC777    \n" +
                        "               W77MDP8        ,DNDDDDDDDDDDDDD8O8O   \n" +
                        "             V7PDDDM7        =88DNNDNDDDDDNNNNDOO8D,          \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                           +DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                          IDDDNNNNMM=  /######D8OO888I\n" +
                        "                         :DNNNNNN,  /########/MD888888\n" +
                        "                         O8DNMM    \\########/ +8888DYD\n" +
                        "                         DODDN         TT     D888DD$\n" +
                        "                         $888D:        ||     DPD88D:\n" +
                        "                         $D8D8$        ||    DD8O8D,\n" +
                        "                         $88DN         ||    88OO8D\n" +
                        "                          8DNF+       /||\\   :OOODD\n" +
                        "                          $DMLW    @@@@@@@@@@ 8OO8D\n" +
                        "                           DTRD @@@@@@@@@@@@@@@MMN88\n" +
                        "                            @@@@@@#      #   @@@P788:\n" +
                        "                           @@@@@$  #    #    # @@78O8 \n" +
                        "                          @@@@@R#   #  #   #    @@8DO:\n" +
                        "                         @@@@@GPN #  #000#       @@@@@\n" +
                        "                         @@@@ DWPG  #00000## # # #@@@@\n" +
                        "                         @@@@@#08DN# #000  #     @@@@@\n" +
                        "                          @@@@@ 8DN#    #   #   @@@@@\n" +
                        "                           @@@@@ PDC   #     # @@@@@\n" +
                        "                             @@@@@@ND #      @@@@@@\n" +
                        "                                @@@@@@@@@@DDM@@@\n" +
                        "                                   @@@@@@@@@@");
        public Label label6 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                          ,DDDDDDDDDDDD88OO8NDD\n" +
                        "                      .DD:IO8DNDDDDDD8DDD8OO888DD\n" +
                        "                  ,DDOOD88DD   DDDD888DD8DD8OO8D4DD\n" +
                        "            .PDOOOOO8DDDDN     DDD8888O8888D8OOO$8:DD\n" +
                        "        DPZOO88DDN,           ,DD8888888888OO8888:DDDD7\n" +
                        "       DDDCDPTR               :DD888888888D88ZNDO  DDD7PD7\n" +
                        "                              :DDDD88DDDDDD8888DZ    7:P7D3\n" +
                        "                               DDDDDDDDDDDDDDDOOI       DDP2L\n" +
                        "                              ,DNDDDDDDDDDDDDD8O8O        77KV:\n" +
                        "                             =88DNNDNDDDDDNNNNDOO8D,      CWFBVVRD        \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                            DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                           :DDNNNNMM=  /######D8OO888\n" +
                        "                           DNNNNNND /########/MD88888\n" +
                        "                           DDOONM  \\########/DD88888\n" +
                        "                           8DHORO      TT   DD888DD\n" +
                        "                          :DPPOO:      ||  OPD888$\n" +
                        "                          8DNNEMP      || MD8DPPO\n" +
                        "                           RMMN8P      ||ND8OO88\n" +
                        "                            :GJMNBD   /|NNO8DD \n" +
                        "                             PRBBO@@@NDNNNNOD \n" +
                        "                              @@@@@@RGDNNMRO@@@@@ \n" +
                        "                            @@@@@@CRPNNNNNM #@@@@@@   \n" +
                        "                           @@@@@#  NNNNMPO #   @@@@@\n" +
                        "                          @@@@@  #NNMNNDP8PRD   @@@@@\n" +
                        "                         @@@@@   NNN8N000 DPMPDO @@@@@\n" +
                        "                         @@@@# #DNMCR00000#  MNDDG@@@@\n" +
                        "                         @@@@@ PON88  000#   # ND@@@@@\n" +
                        "                          @@@@@DDDNM  #   #    #@@@@@\n" +
                        "                           @@@@@DOM  #     #   @@@@@\n" +
                        "                             @@@@@@ #       #@@@@@@\n" +
                        "                                @@@@@@@@@@@@@@@@\n" +
                        "                                   @@@@@@@@@@");
        public Label label7 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                            ,DDDDDDDDDD88OO8NDD\n" +
                        "                         :IO8DNDDDDDD8DDD8OO888DD\n" +
                        "                    ,OOD88DDDD DDDD888DD8DD8OO8D4DD\n" +
                        "                  OO8DDDDN     DDD8888O8888D8OOO$8:DD\n" +
                        "                ZOO88DD       ,DD8888888888OO8888:DDDD7\n" +
                        "             :II$ZOD          :DD888888888D88ZNDO DDD7PD7\n" +
                        "            88NMM8            :DDDD88DDDDDD8888DZ   7:P7D3\n" +
                        "           D800NM:             DDDDDDDDDDDDDDDOOI     DDP2LP\n" +
                        "          OO88DDN,            ,DNDDDDDDDDDDDDD8O8O     CWFBVVRD\n" +
                        "         V7PDDDM7            =88DNNDNDDDDDNNNNDOO8D,      \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                           +DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                          IDDDNNNNMM=  /######D8OO888I\n" +
                        "                         :DNNNNNN,  /########/MD888888\n" +
                        "                        8DNMM      \\########/  +D8888D\n" +
                        "                       ODDNN           TT       D888DD\n" +
                        "                       888DDN          ||       PD88D$\n" +
                        "                        $D8D8NZ        ||       D8O8D,\n" +
                        "                          +888DN       ||       8OO8D\n" +
                        "                             88DN+    /||\\     OOODD\n" +
                        "                             ~DDML @@@@@@@@@@ 8OO8DN\n" +
                        "                              @@@@@@@@@@@@@@@@MN888\n" +
                        "                            @@@@@@#    #    #@P788O\n" +
                        "                           @@@@@   #   #   # 78O8@@@\n" +
                        "                          @@@@@     #  #  #  L888@@@@\n" +
                        "                         @@@@@       #000#  :DD88D@@@@\n" +
                        "                         @@@@########00000##OPO8D#@@@@\n" +
                        "                         @@@@@      # 000 # ZO8O,@@@@@\n" +
                        "                          @@@@@    #   #   :88N:@@@@@\n" +
                        "                           @@@@@  #    #  $OOD:@@@@@\n" +
                        "                             @@@@@@    #  N7Z8@@@@@\n" +
                        "                                @@@@@@@@@@DDM@@@\n" +
                        "                                   @@@@@@@@@@");
        public Label label8 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                            ,DDDDDDDDDD88OO8NDD\n" +
                        "                          :O8DNDDDDDD8DDD8OO888DDD:\n" +
                        "                       ,O8DDDD DDDD888DD8DD8OO8D4DDDDPD          \n" +
                        "                      :OO8DDN  DDD8888O8888D8OOO$8: ,OOD88DD\n" +
                        "                     ZO8DDN,  ,DD8888888888OO8888:     =OOOOO8DDN\n" +
                        "                   7IIIODM=   :DD888888888D88ZNDO          7POO88DDNN\n" +
                        "                  DMM8NMM     :DDDD88DDDDDD8888DZ              :P7D3DPDD\n" +
                        "                DDPLRWM        DDDDDDDDDDDDDDDOOI                 DPRMC777    \n" +
                        "               W77MDP8        ,DNDDDDDDDDDDDDD8O8O   \n" +
                        "             V7PDDDM7        =88DNNDNDDDDDNNNNDOO8D,          \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                           +DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                          IDDDNNNNMM=  /######D8OO888I\n" +
                        "                         :DNNNNNN,  /########/MD888888\n" +
                        "                         O8DNMM    \\########/ +8888DYD\n" +
                        "                         DODDN         TT     D888DD$\n" +
                        "                         $888D:        ||     DPD88D:\n" +
                        "                         $D8D8$        ||    DD8O8D,\n" +
                        "                         $88DN         ||    88OO8D\n" +
                        "                          8DNF+       /||\\   :OOODD\n" +
                        "                          $DMLW    @@@@@@@@@@ 8OO8D\n" +
                        "                           DTRD @@@@@@@@@@@@@@@MMN88\n" +
                        "                            @@@@@@#      #   @@@P788:\n" +
                        "                           @@@@@$  #    #    # @@78O8 \n" +
                        "                          @@@@@R#   #  #   #    @@8DO:\n" +
                        "                         @@@@@GPN #  #000#       @@@@@\n" +
                        "                         @@@@ DWPG  #00000## # # #@@@@\n" +
                        "                         @@@@@#08DN# #000  #     @@@@@\n" +
                        "                          @@@@@ 8DN#    #   #   @@@@@\n" +
                        "                           @@@@@ PDC   #     # @@@@@\n" +
                        "                             @@@@@@ND #      @@@@@@\n" +
                        "                                @@@@@@@@@@DDM@@@\n" +
                        "                                   @@@@@@@@@@");
        public Label label9 = new Label(
                "                              :?7OZOO8+\n" +
                        "                        $ZOOOOOOOOO*DM8O\n" +
                        "                        8DDDD888888DDDDD8\n" +
                        "                         DMMNNNDN88888888D:\n" +
                        "                          =MMMMMMMNNN888888\n" +
                        "                            DMNNNNNNNDD88O8O\n" +
                        "                             +DDDDDDDD8OOOO8:\n" +
                        "                             ~DDDDDDD88OOOO8D,\n" +
                        "                          ,DDDDDDDDDDDD88OO8NDD\n" +
                        "                      .DD:IO8DNDDDDDD8DDD8OO888DD\n" +
                        "                  ,DDOOD88DD   DDDD888DD8DD8OO8D4DD\n" +
                        "            .PDOOOOO8DDDDN     DDD8888O8888D8OOO$8:DD\n" +
                        "        DPZOO88DDN,           ,DD8888888888OO8888:DDDD7\n" +
                        "       DDDCDPTR               :DD888888888D88ZNDO  DDD7PD7\n" +
                        "                              :DDDD88DDDDDD8888DZ    7:P7D3\n" +
                        "                               DDDDDDDDDDDDDDDOOI       DDP2L\n" +
                        "                              ,DNDDDDDDDDDDDDD8O8O        77KV:\n" +
                        "                             =88DNNDNDDDDDNNNNDOO8D,      CWFBVVRD        \n" +
                        "                            +8DDDDDNNNNNNNNNNNDOO888\n" +
                        "                            DDDDDDNNNMNNNNNNNMN8O888D\n" +
                        "                           :DDNNNNMM=  /######D8OO888\n" +
                        "                           DNNNNNND /########/MD88888\n" +
                        "                           DDOONM  \\########/DD88888\n" +
                        "                           8DHORO      TT   DD888DD\n" +
                        "                          :DPPOO:      ||  OPD888$\n" +
                        "                          8DNNEMP      || MD8DPPO\n" +
                        "                           RMMN8P      ||ND8OO88\n" +
                        "                            :GJMNBD   /|NNO8DD \n" +
                        "                             PRBBO@@@NDNNNNOD \n" +
                        "                              @@@@@@RGDNNMRO@@@@@ \n" +
                        "                            @@@@@@CRPNNNNNM #@@@@@@   \n" +
                        "                           @@@@@#  NNNNMPO #   @@@@@\n" +
                        "                          @@@@@  #NNMNNDP8PRD   @@@@@\n" +
                        "                         @@@@@   NNN8N000 DPMPDO @@@@@\n" +
                        "                         @@@@# #DNMCR00000#  MNDDG@@@@\n" +
                        "                         @@@@@ PON88  000#   # ND@@@@@\n" +
                        "                          @@@@@DDDNM  #   #    #@@@@@\n" +
                        "                           @@@@@DOM  #     #   @@@@@\n" +
                        "                             @@@@@@ #       #@@@@@@\n" +
                        "                                @@@@@@@@@@@@@@@@\n" +
                        "                                   @@@@@@@@@@");

    }

}
