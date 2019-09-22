function genPlot(nameFile)
% load a file with data points and plots X vs Y 
%
% file must be in same directory and must have a matrix format of octave
% must be first column as X and remaining columns as Y2,Y3,...;Yn 
% separated with whitespaces.

data = load(nameFile);% load file

figure; hold on;%open figure

x=data(:,1);%get first colum vector X
Y=data(:,2:end);%get remaining column vectors Y1, Y2,...,Yn.

for i = 1:length(Y(1,1:end))
	plot(x, Y(:,i),'linewidth',3); % Plot the data
end

set(gca,'fontsize', 18); %set font of numbers on axes 

ylabel('y-label','fontsize',20); % Set the y−axis label
xlabel('x-label','fontsize',20); % Set the x−axis label

%get handler of the legend object -> hleg

%MODIFY HERE according dataset used
hleg=legend('x^3', 'x^5','sqrt(x)'); % place a tag of what represents each line

legend(hleg,'location','northeastoutside'); % place legends outside
set (hleg, 'fontsize', 18); %set legends fontsize

title('Title','fontsize',20); % Set title

%print -dpng 'myPlot.png' % save plot to .png file
%close % to close plot

end