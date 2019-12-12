        Statement stmt = conn.createStatement();
        ResultSet gpaSet = stmt.executeQuery("SELECT GPA \n" +
                "FROM classes \n" +
                "WHERE courseID = 'CSC211' AND semester = 'Fall' AND year = '2019' \n" +
                "ORDER BY GPA");

        String[] gpa = new String[7];
        int count = 0;
        while(set.next()){
            gpa[count] = gpaSet.getString(1);
            count += 1;
        }

        

        System.out.print("\n");
        while(set.next()){
            String setString = set.getString(1);
            System.out.println(setString);
        }


        
        char[] collectionGPA= new char[7];
        List<String> letterList = new ArrayList<String>();
        List<Double> freqList = new ArrayList<Double>();
        char[] letters = new char[4];
        double[] freq = new double[4];
        int total = 0;
        while(set.next()){
            collectionGPA[total] = set.getString(2).charAt(0);
            total++;
        }

        for(int i = 0; i < collectionGPA.length; i++){
            System.out.println("\n" + collectionGPA[i]);
        }

        boolean[] visited = new boolean[total];
        Arrays.fill(visited,false);

        for(int i = 0; i < total; i++){
            if(visited[i] == true){continue;}
            int count = 1;
            for(int j = i + 1; j < total; j++){
                if(collectionGPA[i] == collectionGPA[j]){
                    visited[j] = true;
                    count++;
                }
            }
           //letterList.add(collectionGPA[i]);
            double frequency = count/total;
            freqList.add(frequency);
        }

        for(int i = 0; i < 4; i++ ){
            freq[i] = freqList.get(i);
            letters[i] = letterList.get(i).charAt(0);
        }


        
        Scene scene;
        primaryStage.setTitle("CSC221 - Final Project; David Balaban");
        StackPane pane = new StackPane();
        scene = new Scene(pane,800,500);
        Canvas canvas = new Canvas(800,500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pane.getChildren().add(canvas);

        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        double[] freq = new double[26];
        freq[0] = 3/7;
        freq[1] = 1/7;
        freq[2] = 2/7;
        freq[5] = 3/7;

        for (int i = 0; i < freq.length; i++) {
            int m = i;
            for (int j = i; j < freq.length; j++) {
                if (freq[j] > freq[m]) {
                    m = j;
                }
            }
            double tempDouble;
            tempDouble = freq[i];
            freq[i] = freq[m];
            freq[m] = tempDouble;

            char tempChar;
            tempChar = letters[i];
            letters[i] = letters[m];
            letters[m] = tempChar;
        }


        MyPieChart chart = new MyPieChart(400,250,4,freq,letters);
        chart.draw(gc);
        primaryStage.setScene(scene);
        primaryStage.show();
